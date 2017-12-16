package org.bs.ssh.actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("uploadAction")
@Scope("prototype")
public class UploadAction extends BaseAction {
	private File uploadFile;
	private String fileName;
	private String contentType;
	private ServletContext application = request.getSession().getServletContext();

	public String execute() {
		String realPath = null;
		if (contentType != null) {
			if (contentType.toLowerCase().indexOf("image") > -1) {
				realPath = application.getRealPath("/upload_image");
			} else {
				realPath = application.getRealPath("/upload_file");
			}
		}
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String finalFilename = new SimpleDateFormat(
				"yyyyMMddHHmmssms").format(new Date()) + ext;
		try {
			FileUtils.copyFile(uploadFile, new File(realPath + "/"+ finalFilename));// 异常
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("contentType", contentType);
		request.setAttribute("filename", finalFilename);
		return "success";

	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	// 接收上传文件的文件名
	public void setUploadFileFileName(String fName) {
		fileName = fName;
	}

	// 接收上传文件的类型
	public void setUploadFileContentType(String ct) {
		contentType = ct;
	}

}
