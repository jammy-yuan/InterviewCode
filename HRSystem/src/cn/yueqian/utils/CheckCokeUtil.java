package cn.yueqian.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *��֤��
 */
@WebServlet("/CheckCokeUtil")
public class CheckCokeUtil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width = 100;
		int height = 30;
		// �õ�����
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// �õ�����
		Graphics2D g = (Graphics2D) image.getGraphics();
		// ������ɫ
		g.setColor(Color.white);
		// ������֤�������
		g.fillRect(0, 0, width, height);
		// ������֤��ı߿�
		g.setColor(Color.red);
		g.drawRect(0, 0, width - 1, height - 1);

		// ������߿�ľ���
		int x = 20;
		int y = 20;

		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			// �õ������30��60����
			int a = ran.nextInt(60) - 30;
			// ת���ɸ�30�㵽60��ĽǶ�
			double b = a * Math.PI / 180;
			// �ýǶ�д����
			g.rotate(b, x, y);
			int index = ran.nextInt(str.length());
			char ch = str.charAt(index);
			g.setFont(new Font("΢���ź�", Font.BOLD, 20));
			g.drawString(ch + "", x, y);
			g.rotate(-b, x, y);
			sb.append(ch);
			x += 20;
		}
		// ������������� (x1 y1) (x2 y2) ����
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		for (int i = 0; i < 5; i++) {
			x1 = ran.nextInt(width);
			x2 = ran.nextInt(width);
			y1 = ran.nextInt(height);
			y2 = ran.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}

		HttpSession session = request.getSession();//�õ�session
		//��session��ֵ�������
		session.setAttribute("checkcode", sb.toString());
//		session.setMaxInactiveInterval(60);//������Ч��Ϊ1����
		ImageIO.write(image, "jpg", response.getOutputStream());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
