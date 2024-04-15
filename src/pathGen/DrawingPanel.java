package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;

public class DrawingPanel extends JPanel implements MouseListener {
	private ArrayList<Point> points = new ArrayList<>();
	private Path2D path = new Path2D.Double();
	private Point lastClickedPoint;

	public DrawingPanel() {
		setPreferredSize(new Dimension(600, 400));
		setBackground(Color.white);
		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(2));
		g2d.draw(path);
		for (Point point : points) {
			g.fillOval(point.x - 5, point.y - 5, 10, 10);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point clickedPoint = e.getPoint();
		if (lastClickedPoint == null) {
			path.moveTo(clickedPoint.getX(), clickedPoint.getY());
		} else {
			Point controlPoint1 = new Point((int) ((3 * lastClickedPoint.getX() + clickedPoint.getX()) / 4),
					(int) ((3 * lastClickedPoint.getY() + clickedPoint.getY()) / 4));
			Point controlPoint2 = new Point((int) ((lastClickedPoint.getX() + 3 * clickedPoint.getX()) / 4),
					(int) ((lastClickedPoint.getY() + 3 * clickedPoint.getY()) / 4));
			path.curveTo(controlPoint1.getX(), controlPoint1.getY(),
					controlPoint2.getX(), controlPoint2.getY(),
					clickedPoint.getX(), clickedPoint.getY());
		}
		points.add(clickedPoint);
		lastClickedPoint = clickedPoint;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}