package scripts.gamescripts;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.List;

import org.junit.Test;

import scripts.IPointPathFinder;
import scripts.IZaggerPoint;
import scripts.ZaggerPoint;

public class PointPathFinderTest {

	@Test
	public void testFindPath() {
		IZaggerPoint start = new ZaggerPoint(new Point(0, 0));
		IPointPathFinder finder = new PointPathFinder();
		List<Point> answer = finder.findPath(start, new ZaggerPoint(new Point(0, 10)));
		assertEquals(1, answer.size());
		assertEquals(start.getPoint(), new Point(0,0));
		
		IZaggerPoint endPoint = new ZaggerPoint(new Point(10, 10));
		IZaggerPoint sub1 = new ZaggerPoint(new Point(-1, 5));
		IZaggerPoint sub2 = new ZaggerPoint(new Point(5, 3));
		IZaggerPoint sub3 = new ZaggerPoint(new Point(12, 2));
		
		start.addChild(sub1);
		start.addChild(sub2);
		start.addChild(sub3);
		sub2.addChild(endPoint);
		sub3.addChild(endPoint);
		
		answer = finder.findPath(start, endPoint);
		
		assertEquals(3, answer.size());
		assertEquals(answer.get(0), start.getPoint());
		assertEquals(answer.get(1), sub2.getPoint());
		assertEquals(answer.get(2), endPoint.getPoint());
		
		answer = finder.findPath(start, new ZaggerPoint(new Point(15, 3)));
		assertEquals(2, answer.size());
		assertEquals(answer.get(0), new Point(0, 0));
		assertEquals(answer.get(1), sub3.getPoint());
	}

}
