package cn.yueqian.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.创建磁盘文件项目的工厂类：DiskFileItemFactory
		 * 2.创建核心解析类：request:ServletFileUpload
		 * 3.解析request对象，返回的是一个list集合
		 * 4.遍历list集合，得到相应的数据
		 * 5.保存数据
		 */
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		try {
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem fileItem : list) {
				if(fileItem.isFormField()) {
					String filename = fileItem.getFieldName();
					//处理上传文件的文件名乱码问题
					String value=fileItem.getString("utf-8");
					System.out.println("name=="+filename+",value=="+value);					
				}else {
					String filename = fileItem.getName();
					filename=UUID.randomUUID().toString()+"_"+filename;
					System.out.println("name=="+filename);
					BufferedInputStream in = new BufferedInputStream(fileItem.getInputStream());
					String path="D://"+"/"+filename;
					OutputStream out=new BufferedOutputStream(new FileOutputStream(path));
					byte[] b=new byte[1024];
					int len=0;
					while((len=in.read(b))!=-1) {
						out.write(b, 0, len);
					}
					in.close();
					out.close();
					//清空临时文件
					fileItem.delete();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
