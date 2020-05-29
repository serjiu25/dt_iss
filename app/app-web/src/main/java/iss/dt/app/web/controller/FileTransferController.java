package iss.dt.app.web.controller;

import iss.dt.app.core.model.Paper;
import iss.dt.app.core.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

@RestController
public class FileTransferController {
    String STORAGE_PATH = System.getProperty("user.dir") + "\\storage";
    String[] PAPER_VALID_EXTENSIONS = {".pdf", ".docx"};

    @Autowired
    PaperService paperService;


    // get the extension of a file; i.e. .pdf
    public static String getExtension(String fileName) {
        char ch;
        int len;
        if(fileName==null ||
                (len = fileName.length())==0 ||
                (ch = fileName.charAt(len-1))=='/' || ch=='\\' || //in the case of a directory
                ch=='.' ) //in the case of . or ..
            return "";
        int dotInd = fileName.lastIndexOf('.'),
                sepInd = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));
        if( dotInd<=sepInd )
            return "";
        else
            return fileName.substring(dotInd+1).toLowerCase();
    }


    /**
        HTTP REQUEST EXAMPLE IN TS:

        const formData = new FormData(); // create a new FormData() objects that holds the parameters

        // add the parameters
        formData.append('paperid', id);
        formData.append('abstract', true/false);
        formData.append('file', file);              // where file is the basic ts file type

        this.httpClient.post('http://${environment.serverAddress}:8080/api/uploadPaper', formData);

     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/uploadPaper", method = RequestMethod.POST)
    public ResponseEntity<Object> uploadPaper(@RequestParam("paperid")Long paperid,
                                              @RequestParam("abstract")Boolean abstr,
                                              @RequestParam("file")MultipartFile file) {

        // Get paper from paper id
        Paper paper = paperService.findOne(paperid);

        if (paper == null)
            return new ResponseEntity<>("Could not find paper with id: " + paperid,
                    HttpStatus.BAD_REQUEST);

        String extension = FileTransferController.getExtension(file.getOriginalFilename());

        if (!Arrays.asList(this.PAPER_VALID_EXTENSIONS).contains(extension))
            return new ResponseEntity<>("Invalid extension: " + extension,
                    HttpStatus.BAD_REQUEST);

        String termination;
        if(abstr)
            termination = "abstract";
        else termination = "full";

        String PATH = this.STORAGE_PATH + "\\papers\\" + paperid + "_" + termination + "." + extension;

        File convertFile = new File(STORAGE_PATH + "" + file.getOriginalFilename());
        try {
            if (!convertFile.createNewFile())
                return new ResponseEntity<>("A file with this name already exists! PATH: " + PATH,
                        HttpStatus.FORBIDDEN);

            FileOutputStream out = new FileOutputStream(convertFile);
            out.write(file.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Exception occurred: " + e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(abstr)
            paper.setAbstractURL(PATH);
        else paper.setFullURL(PATH);

        paperService.updatePaper(paper);

        return new ResponseEntity<>("File uploaded successfully! PATH: " + PATH, HttpStatus.OK);
    }


    /**
        Download a paper with the paperid and abstract true/false
        Kinda shady, might throw error if the path is incorrect
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/downloadPaper/{paperid}/{abstract}", method = RequestMethod.GET)
    public FileSystemResource downloadPaper(@PathVariable("paperid") Long paperid,
                                            @PathVariable("abstract") Boolean abstr) {
        Paper paper = paperService.findOne(paperid);
        if (paper == null)
            throw new RuntimeException("eeeh asta e, paperid incorect");

        String PATH;

        if(abstr)
            PATH = paper.getAbstractURL();
        else PATH = paper.getFullURL();

        return new FileSystemResource(PATH);
    }

}
