package scripts;

import static org.junit.Assert.*;

import java.awt.Point;

import objects.ConcreteObject;
import objects.IGameObject;

import org.junit.Test;

public class TopEdgeIntersectorTest {

	@Test
	public void testIsIntersecting() {
		Point start = new Point(0,0);
		Point end = new Point(5, 5);
		IGameObject testObject = new ConcreteObject();
		testObject.setX(2);
		testObject.setY(2);
		testObject.setHeight(2);
		testObject.setWidth(2);
		IIntersectionHelper helper = new TopEdgeIntersector();
		
		boolean answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(0,0);
		end = new Point(1, 1);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(1,0);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(2,0);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(3,0);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(4,0);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(5,0);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
	
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
		assertTrue(answer);
		
		start = new Point(4,0);
		end = new Point(4, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(5,0);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		


		
		
		
		start = new Point(1,1);
		end = new Point(3, 1);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(1,2);
		end = new Point(3, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,3);
		end = new Point(3, 3);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(1,4);
		end = new Point(1, 4);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(1,5);
		end = new Point(3, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
//////////////////
		
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
		assertTrue(answer);
		
		start = new Point(4,0);
		end = new Point(4, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(5,0);
		end = new Point(5, 5);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(5,2);
		end = new Point(9, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		


		start = new Point(0,2);
		end = new Point(5, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(1,2);
		end = new Point(5, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(2,2);
		end = new Point(5, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(3,2);
		end = new Point(5, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(4,2);
		end = new Point(5, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(5,2);
		end = new Point(5, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(0,0);
		end = new Point(1, 1);
		answer = helper.isIntersecting(testObject, start, end);
		assertFalse(answer);
		
		start = new Point(0,0);
		end = new Point(2, 2);
		answer = helper.isIntersecting(testObject, start, end);
		assertTrue(answer);
		
		start = new Point(4, 0);
		end = new Point(3, 6);
		testObject.setWidth(10);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		start = new Point(3, 6);
		end = new Point(4, 0);
		testObject.setWidth(10);
		answer = helper.isIntersecting(testObject, end, start);
		assertTrue(answer);
		
		
		//////////////intersections
		
		
		start = new Point(2, 2);
		end = new Point(2, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, start, end);
		Point intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, start);
		
		start = new Point(3, 2);
		end = new Point(3, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, start);
		
		start = new Point(4, 2);
		end = new Point(4, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, start);
		
		start = new Point(5, 4);
		end = new Point(5, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertFalse(answer);
		assertEquals(intersection, null);
		
		
		
		
		
		
		
		
		
		
		start = new Point(2, 2);
		end = new Point(2, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, start);
		
		start = new Point(3, 2);
		end = new Point(3, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, start);
		
		start = new Point(4, 2);
		end = new Point(4, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, start);
		
		start = new Point(5, 2);
		end = new Point(5, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertFalse(answer);
		assertEquals(intersection, null);
		
		
		
		start = new Point(2, 1);
		end = new Point(2, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(2, 2));
		
		start = new Point(3, 1);
		end = new Point(3, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(3, 2));
		
		start = new Point(2, 1);
		end = new Point(4, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(2, 2));
		
		start = new Point(5, 2);
		end = new Point(5, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertFalse(answer);
		assertEquals(intersection, null);
		
		
		start = new Point(3, 3);
		end = new Point(0, 8);
		testObject.setX(2);
		testObject.setY(4);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(2, 4));
		
		start = new Point(4, 3);
		end = new Point(0, 8);
		testObject.setX(2);
		testObject.setY(4);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(3, 4));
		
		start = new Point(5, 3);
		end = new Point(0, 8);
		testObject.setX(2);
		testObject.setY(4);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(4, 4));
		
		start = new Point(6, 3);
		end = new Point(0, 8);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertFalse(answer);
		assertEquals(intersection, null);
		
		start = new Point(0, 4);
		end = new Point(1, 4);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new TopEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertFalse(answer);
		assertEquals(intersection, null);
		
		start = new Point(0, 2);
		end = new Point(2, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new TopEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(0, 2);
		end = new Point(2, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new TopEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, end);
		
		start = new Point(0, 3);
		end = new Point(2, 3);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new TopEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertFalse(answer);
		assertEquals(intersection, null);
		
		start = new Point(4, 2);
		end = new Point(4, 2);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new TopEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, start);
		
		start = new Point(2, 2);
		end = new Point(2, 9);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new TopEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, start);
		
		start = new Point(4, 9);
		end = new Point(4, 1);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new TopEdgeIntersector();
		answer = helper.isIntersecting(testObject, start, end);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(4, 2));
		
		start = new Point(4, 9);
		end = new Point(4, 1);
		testObject.setX(2);
		testObject.setY(2);
		testObject.setWidth(2);
		testObject.setHeight(2);
		helper = new TopEdgeIntersector();
		answer = helper.isIntersecting(testObject, end, start);
		intersection = helper.getIntersection();
		assertTrue(answer);
		assertEquals(intersection, new Point(4, 2));

	}

}
