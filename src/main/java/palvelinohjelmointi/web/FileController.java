package palvelinohjelmointi.web;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import palvelinohjelmointi.domain.FileModel;
import palvelinohjelmointi.domain.FileModelRepository;

@Controller
public class FileController {
	@Autowired
	private FileModelRepository repository; 	

	// Reading the upload.path value from application.properties and saving it to the uploadFolder variable
    @Value("${upload.path}")
    private String uploadFolder;
    
    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file, Model model) {
    	// Check if the file is empty
        if (file.isEmpty()) {
        	model.addAttribute("msg", "Upload failed");
            return "uploadstatus";
        }
		
		// Save the uploaded file in the upload folder
        try {
            FileModel fileModel = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            repository.save(fileModel);
    
            return "redirect:/files";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "uploadstatus";
    }
    
    // List uploaded files
    @GetMapping("/files")
    public String fileList(Model model) {
    	model.addAttribute("files", repository.findAll());  	
    	return "filelist";
    }
    
    // Download files
    // File content is added to the body of the HTTP response
	@GetMapping("/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		Optional<FileModel> fileOptional = repository.findById(id);
		
		if(fileOptional.isPresent()) {
			FileModel file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
					.body(file.getFile());	
		}
		
		return ResponseEntity.status(404).body(null);
	}    
    
}