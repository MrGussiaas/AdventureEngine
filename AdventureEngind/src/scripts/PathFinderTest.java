package scripts;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.List;

import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IGameObject;

import org.junit.Test;

import ui.ConcreteGameModel;
import ui.IGameModel;

public class PathFinderTest {

	@Test
	public void testFindPath() {
		//testcases1();
		testcases2();
		
		
		
		
		
		
		
		
	}
	
	private void testcases2(){
		PathFinder finder = new PathFinder();
		
		IGameModel model = new ConcreteGameModel();
		
		Point startPoint = new Point(0,3);
		Point endPoint = new Point(10, 3);
		
		IBarrierObject barrier1 = new BarrierObject();
		IBarrierObject barrier2 = new BarrierObject();
		IBarrierObject barrier3 = new BarrierObject();
		
		barrier1.setX(10);
		barrier1.setY(5);
		barrier1.setWidth(5);
		barrier1.setHeight(2);
		barrier2.setX(5);
		barrier2.setY(5);
		barrier2.setWidth(5);
		barrier2.setHeight(10);
		barrier3.setX(15);
		barrier3.setY(5);
		barrier3.setWidth(5);
		barrier3.setHeight(10);
		
		model.addBarrier(barrier1);
		model.addBarrier(barrier2);
		model.addBarrier(barrier3);
		
		endPoint = new Point(13, 10);
		startPoint = new Point(0, 10);
		
		List<Point> answer = finder.findPath(startPoint, endPoint, model);
		System.out.println("xxx");
		
		IBarrierObject barrier1x = new BarrierObject();
		IBarrierObject barrier2x = new BarrierObject();
		IBarrierObject barrier3x = new BarrierObject();
		
		barrier1x.setX(110);
		barrier1x.setY(100);
		barrier1x.setWidth(45);
		barrier1x.setHeight(5);
		barrier2x.setX(105);
		barrier2x.setY(100);
		barrier2x.setWidth(5);
		barrier2x.setHeight(100);
		barrier3x.setX(155);
		barrier3x.setY(100);
		barrier3x.setWidth(5);
		barrier3x.setHeight(100);
		model = new ConcreteGameModel();
	model.addBarrier(barrier1x);
	model.addBarrier(barrier2x);
	model.addBarrier(barrier3x);
	
	endPoint = new Point(120, 125);
	startPoint = new Point(0, 125);
	
	answer = finder.findPath(startPoint, endPoint, model);
	System.out.println("xxx");
		
	}

	private void testcases1() {
		PathFinder finder = new PathFinder();
		
		IGameModel model = new ConcreteGameModel();
		
		Point startPoint = new Point(0,3);
		Point endPoint = new Point(10, 3);
		List<Point> l = finder.findPath(startPoint, endPoint, model);
		
		assertEquals(l.size(), 2);
		Point p1 = l.get(0);
		Point p2 = l.get(1);
		
		assertTrue(p1.getX() == startPoint.getX());
		assertTrue(p1.getY() == startPoint.getY());
		assertTrue(p2.getX() == endPoint.getX());
		assertTrue(p2.getY() == endPoint.getY());
		
		IBarrierObject barrier = new BarrierObject();
		barrier.setX(2);
		barrier.setY(2);
		barrier.setWidth(2);
		barrier.setHeight(2);
		model.addBarrier(barrier);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		assertEquals(l.size(), 3);
		p1 = l.get(0);
		p2 = l.get(1);
		Point p3 = l.get(2);
		Point p4 = null;
		
		assertTrue(p1.getX() == startPoint.getX());
		assertTrue(p1.getY() == startPoint.getY());
		//assertTrue(p4.getX() == endPoint.getX());
		//assertTrue(p4.getY() == endPoint.getY());
		assertTrue(p2.getX() == 2);
		assertTrue(p2.getY() == 5);
		assertEquals(p3, new Point(10, 3));
		
		l = finder.findPath(endPoint, startPoint, model);
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		assertEquals(l.size(), 4);
		assertEquals(p1, endPoint);
		
		assertEquals(p4, startPoint);

		assertEquals(p2, new Point(4, 5));
		assertEquals(p3, new Point(1, 5));
		
		startPoint = new Point(6, 6);
		endPoint = new Point(8, 20);
		
		l = finder.findPath(startPoint, endPoint, model);
		p1 = l.get(0);
		p2 = l.get(1);

		assertEquals(l.size(), 2);
		assertTrue(p1.getX() == startPoint.getX());
		assertTrue(p1.getY() == startPoint.getY());
		assertTrue(p2.getX() == endPoint.getX());
		assertTrue(p2.getY() == endPoint.getY());
		
		barrier.setHeight(10);
		
		
		startPoint = new Point(0, 5);
		endPoint = new Point(10, 5);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		
		assertEquals(4, l.size());
		
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
	
		assertEquals(l.size(), 4);
		assertTrue(p1.getX() == startPoint.getX());
		assertTrue(p1.getY() == startPoint.getY());
		assertEquals(p4, endPoint);
		assertEquals(p2, new Point(2, 1));

		assertEquals(p3, new Point(5, 3));
		
		endPoint = new Point(10, 6);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		assertEquals(4, l.size());
		
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		assertEquals(l.size(), 4);
		assertEquals(p1, startPoint);
		assertEquals(p4, endPoint);
		assertEquals(p2, new Point(2, 1));
		assertEquals(p3, new Point(5, 3));
		
		endPoint = new Point(10, 7);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		assertEquals(4, l.size());
		
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		assertEquals(l.size(), 4);
		assertEquals(p1, startPoint);
		assertEquals(p4, endPoint);
		assertEquals(p2, new Point(2, 1));
		assertEquals(p3, new Point(5, 3));
		
		////test coming from right side
		
		startPoint = new Point(0, 5);
		endPoint = new Point(10, 5);
		finder = new PathFinder();
		finder = new PathFinder();
		finder = new PathFinder();
		l = finder.findPath(endPoint, startPoint, model);
		assertEquals(4, l.size());
		
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		assertEquals(l.size(), 4);
		assertEquals(p1, endPoint);
		assertEquals(p4,startPoint);
		assertEquals(p2, new Point(4, 1));
		assertEquals(p3, new Point(1, 1));
		
		endPoint = new Point(10, 6);
		finder = new PathFinder();
		l = finder.findPath(endPoint, startPoint, model);
		assertEquals(4, l.size());
		
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		assertEquals(l.size(), 4);
		assertEquals(p1, endPoint);
		assertEquals(p4, startPoint);
		assertEquals(p2, new Point(4, 1));
		assertEquals(p3, new Point(1, 1));
		startPoint = new Point(10, 7);
		endPoint = new Point(0, 10);
		finder = new PathFinder();
		l = finder.findPath(endPoint, startPoint, model);
		assertEquals(4, l.size());
		
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		assertEquals(l.size(), 4);
		assertEquals(p1, endPoint);
		assertEquals(p4, startPoint);
		assertEquals(p2, new Point(2, 1));
		assertEquals(p3, new Point(5, 3));
		
		///////////// testing from bottom
		
		barrier.setX(2);
		barrier.setY(2);
		barrier.setWidth(2);
		barrier.setHeight(2);
		
		startPoint = new Point(3, 6);
		endPoint = new Point(3, 0);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		assertEquals(4, l.size());
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		
		assertEquals(p1, startPoint);
		assertEquals(p4, endPoint);
		assertEquals(p2, (new Point(5, 5)));
		assertEquals(p3, new Point(4, 1));
		barrier.setWidth(10);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		
		assertEquals(4, l.size());
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		
		assertEquals(p1, startPoint);
		assertEquals(p4, endPoint);
		assertEquals(p2, new Point(1, 5));
		assertEquals(p3, new Point(2, 1));
		
		startPoint = new Point(4, 0);
		endPoint = new Point(3, 6);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		
		
		assertEquals(4, l.size());
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		
		assertEquals(p1, startPoint);
		assertEquals(p4, endPoint);
		assertEquals(p2, new Point(1, 1));
		assertEquals(p3, new Point(2, 5));
		endPoint = new Point(5, 0);
		
		l = finder.findPath(startPoint, endPoint, model);
		
		assertEquals(2, l.size());
		p1 = l.get(0);
		p2 = l.get(1);
		//p3 = l.get(2);
		
		assertTrue(p1.equals(startPoint));
		assertTrue(p2.equals(endPoint));
		//assertTrue(p2.equals(new Point(3, 3)));
		
		endPoint = new Point(6, 0);
		startPoint = new Point(3, 6);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		
		assertEquals(4, l.size());
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		
		assertEquals(p1, startPoint);
		assertEquals(p4, endPoint);
		assertEquals(p2, new Point(1, 5));
		assertEquals(p3, new Point(2, 1));
		
		
///////////// testing from top
		
		barrier.setX(2);
		barrier.setY(2);
		barrier.setWidth(2);
		barrier.setHeight(2);
		
		endPoint = new Point(3, 6);
		startPoint = new Point(3, 0);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		assertEquals(3, l.size());
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		
		assertTrue(p1.equals(startPoint));
		assertTrue(p3.equals(endPoint));
		assertEquals(p2, new Point(5, 3));
		
		barrier.setWidth(10);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		
		assertEquals(4, l.size());
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		
		assertEquals(p1, startPoint);
		assertEquals(p4, endPoint);
		assertEquals(p2, new Point(1, 1));
		assertEquals(p3, new Point(2, 5));
		
		startPoint = new Point(4, 0);
		endPoint = new Point(3, 6);
		
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		
		
		assertEquals(4, l.size());
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		
		assertEquals(p1, startPoint);
		assertEquals(p4, endPoint);
		assertEquals(p2, new Point(1, 1));
		assertEquals(p3, new Point(2, 5));
		
		endPoint = new Point(5, 0);
		
		l = finder.findPath(startPoint, endPoint, model);
		
		assertEquals(2, l.size());
		p1 = l.get(0);
		p2 = l.get(1);
		//p3 = l.get(2);
		
		assertTrue(p1.equals(startPoint));
		assertTrue(p2.equals(endPoint));
		//assertTrue(p2.equals(new Point(3, 3)));
		
		startPoint = new Point(6, 0);
		endPoint = new Point(3, 6);
		
		//// testing left with 2 barriers
		
		startPoint = new Point(0, 5);
		endPoint = new Point(20, 5);
		
		barrier.setX(1);
		barrier.setY(2);
		barrier.setWidth(2);
		barrier.setHeight(20);
		IBarrierObject barrier2 = new BarrierObject();
		barrier2.setX(15);
		barrier2.setY(2);
		barrier2.setWidth(2);
		barrier2.setHeight(20);
		model.addBarrier(barrier2);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		assertEquals(5, l.size());
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		Point p5 = l.get(4);
		assertEquals(p1, startPoint);
		assertEquals(p5, endPoint);
		assertEquals(p2, new Point(1, 1));
		assertEquals(p3, new Point(15, 1));
		assertEquals(p4, new Point(18, 3));		

		finder = new PathFinder();
		l = finder.findPath(endPoint, startPoint, model);
		assertEquals(6, l.size());
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		p5 = l.get(4);
		Point p6 = l.get(5);
		assertEquals(p1, endPoint);
		assertEquals(p6, startPoint);
		assertEquals(p2, new Point(17, 1));
		assertEquals(p3, new Point(3, 1));
		assertEquals(p4, new Point(3, 1));
		assertEquals(p5, new Point(0, 1));

		
		IBarrierObject barrier3 = new BarrierObject();
		startPoint = new Point(0, 10);
		endPoint = new Point(20, 10);
		model.addBarrier(barrier3);
		
		barrier3.setX(17);
		barrier3.setY(2);
		barrier3.setWidth(2);
		barrier3.setHeight(20);
		
		barrier2.setX(2);
		barrier2.setY(2);
		barrier2.setWidth(2);
		barrier2.setHeight(20);
		
		barrier.setX(10);
		barrier.setY(2);
		barrier2.setWidth(2);
		barrier.setHeight(20);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		assertEquals(8, l.size());

		
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		p5 = l.get(4);
		p6 = l.get(5);
		Point p7 = l.get(6);
		Point p8 = l.get(7);
		
		assertEquals(p1, startPoint);
		assertEquals(p8, endPoint);
		assertEquals(p2, new Point(2, 1));
		assertEquals(p3, new Point(10, 1));
		assertEquals(p4, new Point(10, 1));
		assertEquals(p5, new Point(9, 1));
		assertEquals(p6, new Point(17, 1));
		assertEquals(p7, new Point(20, 3));
		
		l = finder.findPath(endPoint, startPoint, model);
		assertEquals(6, l.size());
		
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		p5 = l.get(4);
		p6 = l.get(5);
		p7 = null;
		
		assertEquals(p1, endPoint);
		assertEquals(p6, startPoint);
		assertEquals(p2, new Point(19, 23));
		assertEquals(p3, new Point(12, 1));
		assertEquals(p4, new Point(4, 1));
		assertEquals(p6, new Point(0, 10));
		
		for(int i = 0, n = model.getBarrierCount(); i < n; i++){
			model.removeBarrier(0);
		}
		
		barrier.setX(5);
		barrier.setY(5);
		barrier.setHeight(2);
		barrier.setWidth(20);
		
		barrier2.setX(5);
		barrier2.setY(10);
		barrier2.setHeight(2);
		barrier2.setWidth(20);
		
		model.addBarrier(barrier);
		model.addBarrier(barrier2);
		
		startPoint.setLocation(10, 0);
		endPoint.setLocation(10, 30);
		finder = new PathFinder();
		l = finder.findPath(startPoint, endPoint, model);
		assertEquals(4, l.size());
		
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		//p5 = l.get(4);
		
		assertEquals(p1, startPoint);
		assertEquals(p4, endPoint);
		assertEquals(p2, new Point(4, 4));
		assertEquals(p3, new Point(4, 9));
		
		finder = new PathFinder();
		l = finder.findPath(endPoint, startPoint, model);
		assertEquals(5, l.size());
		
		p1 = l.get(0);
		p2 = l.get(1);
		p3 = l.get(2);
		p4 = l.get(3);
		p5 = l.get(4);
		
		assertEquals(p1, endPoint);
		assertEquals(p5, startPoint);
		assertEquals(p2, new Point(26, 13));
		assertEquals(p3, new Point(4, 8));
		assertEquals(p4, new Point(5, 4));
		
		finder = new PathFinder();
		for(int i = 0, n = model.getBarrierCount(); i < n; i++){
			model.removeBarrier(0);
		}
		barrier.setX(5);
		barrier.setY(5);
		barrier.setHeight(4);
		barrier.setWidth(5);
		model.addBarrier(barrier);
		barrier2.setX(7);
		barrier2.setY(3);
		barrier2.setWidth(4);
		barrier2.setHeight(5);
		model.addBarrier(barrier2);
		

		
		model = new ConcreteGameModel();
		/*barrier.setX(10);
		barrier.setY(10);
		barrier.setHeight(10);
		barrier.setWidth(50);
		
		barrier2.setX(10);
		barrier2.setY(11);
		barrier2.setWidth(10);
		barrier2.setHeight(50);
		
		barrier3.setX(10);
		barrier3.setY(50);
		barrier3.setWidth(50);
		barrier3.setHeight(10);
		
		IBarrierObject barrier4 = new BarrierObject();
		barrier4.setX(49);
		barrier4.setY(50);
		barrier4.setWidth(10);
		barrier4.setHeight(50);
		
		model.addBarrier(barrier);
		model.addBarrier(barrier2);
		model.addBarrier(barrier3);
		model.addBarrier(barrier4);*/
		
		model = new ConcreteGameModel();
		
		barrier = new BarrierObject();
		barrier.setX(10);
		barrier.setY(10);
		barrier.setWidth(10);
		barrier.setHeight(10);
		
		model.addBarrier(barrier);
		
		startPoint = new Point(0, 15);
		endPoint = new Point(15, 15);
		
		List<Point> listy = finder.findPath(startPoint, endPoint, model);
		//assertEquals(listy.size(), 0);
		
		model = new ConcreteGameModel();
		
		barrier = new BarrierObject();
		barrier.setX(10);
		barrier.setY(11);
		barrier.setHeight(10);
		barrier.setWidth(50);
		
		barrier2 = new BarrierObject();
		barrier2.setX(11);
		barrier2.setY(10);
		barrier2.setWidth(10);
		barrier2.setHeight(50);
		
		barrier3 = new BarrierObject();
		barrier3.setX(10);
		barrier3.setY(49);
		barrier3.setWidth(50);
		barrier3.setHeight(10);
		
		IBarrierObject barrier4 = new BarrierObject();
		barrier4.setX(49);
		barrier4.setY(10);
		barrier4.setWidth(10);
		barrier4.setHeight(50);
		
		model.addBarrier(barrier);
		model.addBarrier(barrier2);
		model.addBarrier(barrier3);
		model.addBarrier(barrier4);
		
		Point start = new Point(15, 0);
		Point end = new Point(15, 25);
		finder = new PathFinder();
		listy = finder.findPath(start, end, model);
		assertEquals(listy.size(), 1);
		
		
		
		model = new ConcreteGameModel();
		
		barrier = new BarrierObject();
		barrier.setX(10);
		barrier.setY(10);
		barrier.setHeight(10);
		barrier.setWidth(50);
		
		barrier2 = new BarrierObject();
		barrier2.setX(10);
		barrier2.setY(10);
		barrier2.setWidth(10);
		barrier2.setHeight(50);
		
		barrier3 = new BarrierObject();
		barrier3.setX(10);
		barrier3.setY(50);
		barrier3.setWidth(50);
		barrier3.setHeight(10);
		
		barrier4 = new BarrierObject();
		barrier4.setX(50);
		barrier4.setY(10);
		barrier4.setWidth(10);
		barrier4.setHeight(50);
		
		model.addBarrier(barrier);
		model.addBarrier(barrier2);
		model.addBarrier(barrier3);
		model.addBarrier(barrier4);
		
		start = new Point(15, 0);
		end = new Point(15, 25);
		finder = new PathFinder();
		listy = finder.findPath(start, end, model);
		assertEquals(listy.size(), 1);
		
		start = new Point(15, 70);
		
		listy = finder.findPath(start, end, model);
		assertEquals(listy.size(), 1);
	}

}
