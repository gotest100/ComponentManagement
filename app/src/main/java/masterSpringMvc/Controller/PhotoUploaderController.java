package masterSpringMvc.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PhotoUploaderController {
	public static final Resource PICTURE_PATH = new FileSystemResource("./photos");
	
	@RequestMapping("/profile/upload")
	public String upload() {
		return "/profile/uploadPhoto";
	}
	
	@RequestMapping(value = "/profile/upload", method = RequestMethod.POST)
	public String OnUpload(MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		File tempFile = File.createTempFile("pic", getFileExtension(fileName), PICTURE_PATH.getFile());
		
		try {
			InputStream is = file.getInputStream();
			OutputStream os = new FileOutputStream(tempFile);
			IOUtils.copy(is, os);
		}
		catch(Exception ex) {
			//do nothing
		}
		
		return "/profile/uploadPhoto";
	}
	
	private static String getFileExtension(String name) {
		return name.substring(name.lastIndexOf("."));
		}

}
