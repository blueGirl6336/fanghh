package hitwh.fanghh.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpSession;

public class RandomUtil
{
	private static final String SMAILL_EN_STRING = "abcdefghijklmnopqrstuvwxyz";
	private static final String BIG_EN_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUM_STRING = "0123456789";

	/**
	 * 返回长度为length的随机字符串，范围为[0-9]&&[a-z]&&[A-Z]
	 *
	 * @Title: getRandomEnAndNumString
	 * @version:
	 * @author: ZY
	 * 
	 * @param length要得到的字符串长度
	 * @return
	 */
	public static String getRandomEnAndNumString(int length)
	{
		if (length <= 0)
		{
			throw new IllegalArgumentException("length必须大于0,length:" + length);
		}
		String tmp = BIG_EN_STRING + SMAILL_EN_STRING + NUM_STRING;
		StringBuffer stringBuffer = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++)
		{
			stringBuffer.append(tmp.charAt(random.nextInt(tmp.length())));
		}
		return stringBuffer.toString();
	}

	/**
	 * 获取随机数字
	 *
	 * @Title: getRandomIntNum
	 * @version:
	 * @author: ZY
	 * 
	 * @param min最小值
	 * @param max最大值
	 * @return
	 */
	public static int getRandomIntNum(int min, int max)
	{
		if (max < min)
		{
			throw new IllegalArgumentException("最大值max必须不小于最小值min;max:" + max + ",min:" + min);
		}
		Random random = new Random();
		return min + random.nextInt(max - min + 1);
	}

	/**
	 * 生成验证码图片
	 *
	 * @Title: getRandomCheckCodeImage
	 * @version:
	 * @author: ZY
	 * 
	 * @param width图片宽
	 * @param height图片高度宽度
	 * @param lineSize干扰线数量
	 * @param stringSize字体大小
	 * @param session
	 * @return
	 */
	public static BufferedImage getRandomCheckCodeImage(int width, int height, int lineSize, int stringSize,
			HttpSession session)
	{
		if (width <= 0 || height <= 0 || lineSize <= 0 || stringSize <= 0)
		{
			throw new IllegalArgumentException("非法参数！");
		}

		final String caculateSymbols;// 指定加法减法符号
		int num1 = getRandomIntNum(0, 20);// 20以内的随机数
		int num2 = getRandomIntNum(0, num1);// 确保减法结果大于0
		int checkCode = 0;

		if (getRandomIntNum(0, 1) == 0)
		{
			checkCode = num1 + num2;
			caculateSymbols = "+";
		} else
		{
			checkCode = num1 - num2;
			caculateSymbols = "-";
		}
		session.setAttribute("checkCode", String.valueOf(checkCode));

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics graphics = image.getGraphics();

		// 矩形图片
		graphics.fillRect(0, 0, width, height);
		// 字体
		graphics.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, stringSize));

		// 绘制随机灰色干扰线
		graphics.setColor(Color.GRAY);
		for (int i = 0; i < lineSize; i++)
		{
			int x1 = getRandomIntNum(0, width / 4);
			int x2 = getRandomIntNum(width / 4 * 3, width);
			int y1 = getRandomIntNum(0, height);
			int y2 = getRandomIntNum(0, height);

			graphics.drawLine(x1, y1, x2, y2);
		}

		// 字体颜色，低于150看得清
		int r = getRandomIntNum(0, 150);
		int g = getRandomIntNum(0, 150);
		int b = getRandomIntNum(0, 150);
		graphics.setColor(new Color(r, g, b));

		// 绘制字符
		Graphics2D graphics2d = (Graphics2D) graphics;

		// 字符旋转角度，注意旋转后得转回来
		double rotateNum = getRandomIntNum(-600, 600) / 1000.0;

		graphics2d.rotate(rotateNum, width / 5 * 1 / 2, height / 4 * 3);
		graphics.drawString(String.valueOf(num1), width / 5 * 0, height / 4 * 3);
		graphics2d.rotate(-rotateNum, width / 5 * 1 / 2, height / 4 * 3);

		graphics.drawString(caculateSymbols, width / 5, height / 4 * 3);

		rotateNum = getRandomIntNum(-300, 300) / 1000.0;
		graphics2d.rotate(rotateNum, width / 5 * 5 / 2, height / 4 * 3);
		graphics.drawString(String.valueOf(num2), width / 5 * 2, height / 4 * 3);
		graphics2d.rotate(-rotateNum, width / 5 * 5 / 2, height / 4 * 3);

		graphics.drawString("=", width / 5 * 3, height / 4 * 3);

		graphics.drawString("?", width / 5 * 4, height / 4 * 3);

		graphics.dispose();

		return image;
	}
}
