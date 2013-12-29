package scripts;

import static org.junit.Assert.*;

import java.awt.Point;

import objects.ConcreteObject;
import objects.IGameObject;

import org.junit.Test;

public class RightEdgeIntersectorTest {

	@Test
	public void testIsIntersecting() {
		Point start = new Point(0,0);
		Point end = new Point(5, 5);
		IGameObject testObject = new ConcreteObject();
		testObject.setX(2);
		testObject.setY(2);
		testObject.setHeight(2);
		testObject.setWidth(2);
		IIntersectionHelper helper = new RightEdgeIntersector();
		
		boolean answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(5,2);
		end = new Point(9, 2);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(0,1);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(0,1);
		end = new Point(5, 4);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(0,1);
		end = new Point(5, 3);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(0,1);
		end = new Point(5, 2);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(0,1);
		end = new Point(5, 1);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(0,0);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(1,1);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(2,2);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(3,3);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(4,4);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(1,1);
		end = new Point(2, 2);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(8,5);
		end = new Point(5, 10);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(1,4);
		end = new Point(5, 4);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(1,4);
		end = new Point(5, 4);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(1,1);
		end = new Point(5, 1);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(1,2);
		end = new Point(5, 2);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(1,3);
		end = new Point(5, 3);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(1,4);
		end = new Point(5, 4);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(1,5);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(1,1);
		end = new Point(1, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		

		
		start = new Point(1,1);
		end = new Point(2, 1);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(0,1);
		end = new Point(1, 1);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(1,3);
		end = new Point(2, 3);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		
		start = new Point(3,3);
		end = new Point(4, 3);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(4,10);
		end = new Point(0, 0);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(4,10);
		end = new Point(10, 0);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(5,5);
		end = new Point(6, 0);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(5,5);
		end = new Point(0, 0);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		
		testObject.setX(200);
		testObject.setY(2);
		testObject.setHeight(2);
		testObject.setWidth(2);
		start = new Point(0,0);
		end = new Point(100, 100);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		testObject.setX(2);
		testObject.setY(2);
		testObject.setHeight(2);
		testObject.setWidth(2);
		
		start = new Point(1,0);
		end = new Point(1, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(2,0);
		end = new Point(2, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(3,0);
		end = new Point(3, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(4,0);
		end = new Point(4, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(5,0);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(0,0);
		end = new Point(3, 0);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(0,1);
		end = new Point(3, 1);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(3,2);
		end = new Point(5, 2);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(3,3);
		end = new Point(5, 3);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(3,4);
		end = new Point(5, 4);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(3,5);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(4,0);
		end = new Point(4, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(4,1);
		end = new Point(4, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(4,2);
		end = new Point(4, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(4,3);
		end = new Point(4, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(4,4);
		end = new Point(4, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(4,5);
		end = new Point(4, 5);
		answer = helper.isIntersecting(testObject, end, start);
		assertFalse(answer);
		
		start = new Point(6,0);
		end = new Point(4, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		Point intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(6,1);
		end = new Point(4, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(6,2);
		end = new Point(4, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(6,3);
		end = new Point(4, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(6,4);
		end = new Point(4, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(6,5);
		end = new Point(4, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(6,5);
		end = new Point(4, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(6,5);
		end = new Point(4, 4);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(6,5);
		end = new Point(4, 5);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertFalse(answer);
		assertEquals(null, intersection);
		
		start = new Point(3,2);
		end = new Point(8, 0);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertFalse(answer);
		assertEquals(null, intersection);
		
		start = new Point(3,2);
		end = new Point(8, 1);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertFalse(answer);
		assertEquals(null, intersection);
		
		start = new Point(3,2);
		end = new Point(8, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(new Point(4, 2), intersection);
		
		start = new Point(3,2);
		end = new Point(8, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(new Point(4, 2), intersection);
		
		start = new Point(3,2);
		end = new Point(8, 4);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(new Point(4, 2), intersection);
		
		start = new Point(3,2);
		end = new Point(8, 5);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(new Point(4, 2), intersection);
		
		start = new Point(4,0);
		end = new Point(4, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(new Point(4, 2), intersection);
		
		
		start = new Point(4,8);
		end = new Point(4, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new RightEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(new Point(4, 4), intersection);
	}

}
