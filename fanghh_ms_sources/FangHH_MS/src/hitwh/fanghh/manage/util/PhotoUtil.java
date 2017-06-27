package hitwh.fanghh.manage.util;


import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class PhotoUtil {
	public static final int WIDTH=300,HEIGHT=400;
	/**
	 * 通过类文件获取图片存储位置
	 * @param class1
	 * @return 图片文件夹名称
	 * @throws IOException
	 */
	public static String getDirNameByClassPath(Class class1) throws IOException {
		String name=Path.getPathFromClass(class1);
		return name.substring(0,name.indexOf("hrms")+5)+"admin"+File.separator+"portrait";
	}
/**
 * 根据工号生成图片名称
 * @param empNo
 * @param imgFile1
 * @return
 */
	public static String getPhotoFileName(String empNo, MultipartFile imgFile1) {
		return StringUtils.encrypt_MD5(empNo)+
				imgFile1.getOriginalFilename().substring(imgFile1.getOriginalFilename().indexOf(".")).toLowerCase();
	}
/**
 * 将图片文件f经过裁剪后存入newFile，并改变ppt中的值
 * @param f
 * @param newFile
 * @param ppt
 * @throws Exception
 */
	/*public static void translate(MultipartFile f, File newFile,
			TPortrait ppt) throws Exception {
		String format=f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf(".")+1).toUpperCase();
		if(!checkImageFile(format))throw new Exception("Wrong format");
		Image src = ImageIO.read(f.getInputStream());
		
		int w = src.getWidth(null);    
        int h = src.getHeight(null);
        if(((double)w/(double)h)>((double)WIDTH/(double)HEIGHT)){
        	double percent=(double)WIDTH/(double)w;
        	int newHeight=(int) (percent*h);
        	BufferedImage image = new BufferedImage(WIDTH, newHeight, BufferedImage.TYPE_INT_BGR);    
            Graphics graphics = image.createGraphics();    
            graphics.drawImage(src, 0, 0, WIDTH, newHeight, null);    
            ImageIO.write(image, format, newFile);
            ppt.setWidth(WIDTH);
            ppt.setHeight(newHeight);
        }else{
        	double percent=(double)HEIGHT/(double)h;
        	int newWidth=(int) (percent*w);
        	BufferedImage image = new BufferedImage(newWidth, HEIGHT, BufferedImage.TYPE_INT_BGR);    
            Graphics graphics = image.createGraphics();    
            graphics.drawImage(src, 0, 0, newWidth, HEIGHT, null);    
            ImageIO.write(image, format, newFile);
            ppt.setWidth(newWidth);
            ppt.setHeight(HEIGHT);
        }
	}*/
	/**
	 * 判断是否为图片后缀名
	 * @param extName
	 * @return
	 */
	public static boolean checkImageFile(String extName) {    
        if ("jpg".equalsIgnoreCase(extName))    
            return true;    
        if ("jpeg".equalsIgnoreCase(extName))    
            return true;    
        if ("png".equalsIgnoreCase(extName))    
            return true;    
        return false;    
    } 
	/**
	 * 通过绝对文件路径获取相对路径，用在页面中
	 * @param name
	 * @return
	 */
	public static String getRelatedPath(String filename){
		if(filename!=null&&filename.length()>=filename.indexOf("hrms") + 4)
			return filename.substring(filename.indexOf("hrms") + 5);
		else return "";
	}
}
