package scripts;

import static org.junit.Assert.*;

import java.awt.Point;

import objects.ConcreteObject;
import objects.IGameObject;

import org.junit.Test;

public class LeftEdgeIntersectorTest {

	@Test
	public void testIsIntersecting() {
		Point start = new Point(0,0);
		Point end = new Point(5, 5);
		IGameObject testObject = new ConcreteObject();
		testObject.setX(2);
		testObject.setY(2);
		testObject.setHeight(2);
		testObject.setWidth(2);
		IIntersectionHelper helper = new LeftEdgeIntersector();
		
		boolean answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,1);
		end = new Point(2, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,1);
		end = new Point(0, 0);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(0,0);
		end = new Point(1, 1);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(5,2);
		end = new Point(9, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(0,1);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(0,2);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(0,3);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(0,4);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(0,5);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(0,0);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,1);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,2);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,3);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,4);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(1,5);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(8,5);
		end = new Point(5, 10);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(1,4);
		end = new Point(5, 4);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,4);
		end = new Point(5, 4);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,1);
		end = new Point(5, 1);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(1,2);
		end = new Point(5, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,3);
		end = new Point(5, 3);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,4);
		end = new Point(5, 4);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,5);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(1,1);
		end = new Point(1, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		/*start = new Point(2,1);
		end = new Point(2, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);*/
		
		start = new Point(1,1);
		end = new Point(2, 1);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(0,1);
		end = new Point(1, 1);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(1,3);
		end = new Point(2, 3);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(4,10);
		end = new Point(0, 0);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(4,10);
		end = new Point(10, 0);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(5,5);
		end = new Point(6, 0);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(5,5);
		end = new Point(0, 0);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		
		testObject.setX(200);
		testObject.setY(2);
		testObject.setHeight(2);
		testObject.setWidth(2);
		start = new Point(0,0);
		end = new Point(100, 100);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		testObject.setX(2);
		testObject.setY(2);
		testObject.setHeight(2);
		testObject.setWidth(2);
		
		start = new Point(1,0);
		end = new Point(1, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(2,0);
		end = new Point(2, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(3,0);
		end = new Point(3, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(4,0);
		end = new Point(4, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(5,0);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(0,0);
		end = new Point(3, 0);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(0,1);
		end = new Point(3, 1);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(0,2);
		end = new Point(3, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(0,3);
		end = new Point(3, 3);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(0,4);
		end = new Point(3, 4);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(0,5);
		end = new Point(3, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(2,0);
		end = new Point(2, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		


		
		
		start = new Point(2,1);
		end = new Point(2, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(2,2);
		end = new Point(2, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(2,3);
		end = new Point(2, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(2,4);
		end = new Point(2, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(2,5);
		end = new Point(2, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		/////////////////////// point intersections
		
		start = new Point(0,0);
		end = new Point(2, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		Point intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(0,1);
		end = new Point(2, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(0,2);
		end = new Point(2, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(0,3);
		end = new Point(2, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(0,4);
		end = new Point(2, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(0,5);
		end = new Point(2, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(0,5);
		end = new Point(2, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(0,5);
		end = new Point(2, 4);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(0,5);
		end = new Point(2, 5);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new LeftEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertFalse(answer);
		assertEquals(null, intersection);
		
		start = new Point(0,0);
		end = new Point(2, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		helper = new LeftEdgeIntersector();
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, null);
		
		start = new Point(0,1);
		end = new Point(3, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new LeftEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(new Point(2, 2), intersection);
		
		start = new Point(0,2);
		end = new Point(3, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new LeftEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(2, 2));
		
		start = new Point(0,3);
		end = new Point(3, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new LeftEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(2, 3));
		
		start = new Point(0,4);
		end = new Point(3, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new LeftEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(2, 3));
		
		start = new Point(0,5);
		end = new Point(3, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new LeftEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(2, 3));
		
		start = new Point(0,5);
		end = new Point(4, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new LeftEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(2, 4));
		
		start = new Point(0,5);
		end = new Point(5, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new LeftEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(2, 3));
		
		start = new Point(2,0);
		end = new Point(2, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new LeftEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(2, 2));
		
		start = new Point(3,3);
		end = new Point(20, 5);
		testObject.setX(15);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(20);
		helper = new LeftEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		//assertEquals(intersection, new Point(2, 2));
		
		start = new Point(0, 5);
		end = new Point(10, 5);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(10);
		helper = new LeftEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		
		
		
		
		

		
	}

}
