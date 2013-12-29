package scripts;

import static org.junit.Assert.*;

import java.awt.Point;

import objects.BarrierObject;
import objects.IBarrierObject;

import org.junit.Test;

import ui.ConcreteGameModel;

public class TopPointFinderTest {

	@Test
	public void testGetPoint1() {
		IPointFinder testFinder = new TopPointFinder();
		IPointFinder leftFinder = new LeftPointFinder();
		IBarrierObject barrier = new BarrierObject();
		barrier.setX(0);
		barrier.setY(0);
		barrier.setWidth(10);
		barrier.setHeight(5);
		Point p1 = testFinder.getPoint1(barrier, new ConcreteGameModel(), new Point(0, 0));
		Point p2 = leftFinder.getPoint1(barrier, new ConcreteGameModel(), new Point(0, 0));
		assertEquals(p1, p2);
	}

	@Test
	public void testGetPoint2() {
		IPointFinder testFinder = new TopPointFinder();
		IPointFinder leftFinder = new RightPointFinder();
		IBarrierObject barrier = new BarrierObject();
		barrier.setX(0);
		barrier.setY(0);
		barrier.setWidth(10);
		barrier.setHeight(5);
		Point p1 = testFinder.getPoint2(barrier, new ConcreteGameModel(), new Point(0, 0));
		Point p2 = leftFinder.getPoint1(barrier, new ConcreteGameModel(), new Point(0, 0));
		assertEquals(p1, p2);
	}

}
