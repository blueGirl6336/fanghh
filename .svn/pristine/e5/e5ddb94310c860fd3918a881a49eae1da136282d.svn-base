<%@ page contentType="image/jpeg;charset=UTF-8"%>
<%@ page import="java.awt.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.awt.image.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.imageio.*"%>
<!-- 在指定的数值范围内生成一种随机色 -->
<%!Color getRandColor(int lower, int upper) {
		//创建随机数类变量
		Random random = new Random();
		//防止数值范围出界
		lower = (lower < 0 || lower > 255) ? 0 : lower;
		upper = (upper < 0 || upper > 255) ? 0 : upper;
		//生成红绿蓝三种基本色的随机数值
		int r = lower + random.nextInt(upper - lower);
		int g = lower + random.nextInt(upper - lower);
		int b = lower + random.nextInt(upper - lower);
		//返回生成的随机色
		return new Color(r, g, b);
	}%>
<%!String getRandomStr(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getRandomChar());
		}
		return sb.toString();
	}%>
<%!char getRandomChar() {
		//随机字符1-9,a-z,A-Z
		char[] cs = new char[3];
		cs[0] = (char) ((int) (Math.random() * 10) + '0');
		cs[1] = (char) ((int) (Math.random() * 24) + 'a');
		cs[2] = (char) ((int) (Math.random() * 24) + 'A');
		return cs[(int) (Math.random() * 3)];
	}%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	//图片的初始大小
	int width = 80;
	int height = 40;
	//创建缓冲图片
	BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	//获取缓冲图片的绘图类变量
	Graphics g = image.getGraphics();
	//设置前景色（为较亮的一种随机色）
	g.setColor(getRandColor(200, 255));
	//使用该色填充背景
	g.fillRect(0, 0, width, height);
	//创建随机数类变量
	Random random = new Random();
	//产生100条具有随机位置、随机长度和随机颜色的干扰直线，使图象中的认证码不易被其它程序识别出来 
	for (int i = 0; i < 100; i++) {
		//设置前景色（为灰度中等的一种随机色）
		g.setColor(getRandColor(150, 200));
		//获取随机位置
		int x1 = random.nextInt(width);
		int y1 = random.nextInt(height);
		//获取随机长度
		int x2 = random.nextInt(10);
		int y2 = random.nextInt(10);
		//绘制直线
		g.drawLine(x1, y1, x1 + x2, y1 + y2);
	}
	//设定字体
	g.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	//获取1000到9999之间的四位随机整数，Michael Miao修改后为获取四位数字或大小写字母
	//转换为字符串
	String randomStr = getRandomStr(4);
	//循环遍历字符串每个字符
	for (int i = 0; i < randomStr.length(); i++) {
		//设置前景色（为较暗的一种随机色）
		g.setColor(getRandColor(0, 100));
		//显示一个字符
		g.drawString(randomStr.substring(i, i + 1), 20 * i, 30);
	}
	// 将随机数存储在会话属性中，便于其他网页程序判断是否验证成功
	session.setAttribute("randomStr", randomStr);
	g.dispose();
	//输出随机数图片
	OutputStream os=response.getOutputStream(); 
	ImageIO.write(image, "JPEG", response.getOutputStream());
	os.flush();
	os.close();
	os = null;
	response.flushBuffer();
	out.clear();
	out = pageContext.pushBody();
%>
