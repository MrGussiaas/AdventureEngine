package scripts;

import static org.junit.Assert.*;

import java.awt.Point;

import objects.BarrierObject;
import objects.IBarrierObject;

import org.junit.Test;

import ui.ConcreteGameModel;
import ui.IGameModel;

public class ZaggerPointLinkerTest {

	@Test
	public void testLinkZaggerPoints() {
		
		IZaggerPointLinker linker = ZaggerPointLinker.getInstance();
		IZaggerPointModel zaggerModel = new ZaggerPointModel();
		
		//assertEquals(0, zModel.getZaggerPointCount());
		
		
		IGameModel  gameModel = new ConcreteGameModel();
		IBarrierObject barrierObject = new BarrierObject();
		barrierObject.setX(10);
		barrierObject.setWidth(10);
		barrierObject.setY(10);
		barrierObject.setHeight(10);
		gameModel.addBarrier(barrierObject);
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(0, 0)));
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(0, 10)));
		
		linker.linkZaggerPoints(zaggerModel, gameModel);
		assertEquals(2, zaggerModel.getZaggerPointCount());
		
		IZaggerPoint p1 = zaggerModel.getZaggerPoint(0);
		IZaggerPoint p2 =zaggerModel.getZaggerPoint(1);
		
		assertEquals(p1.getPoint(), new Point(0, 0));
		assertEquals(p2.getPoint(), new Point(0, 10));
		
		assertEquals(1, p1.getChildCount());
		assertEquals(1, p2.getChildCount());
		
		assertEquals(p1.getChild(0).getPoint(), p2.getPoint());
		assertEquals(p2.getChild(0).getPoint(), p1.getPoint());
		
		zaggerModel = new ZaggerPointModel();
		IZaggerPoint startPoint = new ZaggerPoint(new Point(0, 0));
		IZaggerPoint endPoint = new ZaggerPoint(new Point(15, 22));
		zaggerModel.addZaggerPoint(startPoint);
		zaggerModel.addZaggerPoint(endPoint);
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(9, 9)));
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(21, 9)));
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(9, 21)));
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(21, 21)));
		
		linker.linkZaggerPoints(zaggerModel, gameModel);
		assertEquals(6, zaggerModel.getZaggerPointCount());
		
		p1 = zaggerModel.getZaggerPoint(0);
		p2 = zaggerModel.getZaggerPoint(1);
		IZaggerPoint p3 = zaggerModel.getZaggerPoint(2);
		IZaggerPoint p4 = zaggerModel.getZaggerPoint(3);
		IZaggerPoint p5 = zaggerModel.getZaggerPoint(4);
		IZaggerPoint p6 = zaggerModel.getZaggerPoint(5);
		
		assertEquals(p1.getChildCount(), 3);
		assertEquals(p1.getChild(0).getPoint(), new Point(9, 9));
		assertEquals(p1.getChild(1).getPoint(), new Point(21, 9));
		assertEquals(p1.getChild(2).getPoint(), new Point(9, 21));
		
		assertEquals(p2.getChildCount(), 2);
		assertEquals(p2.getChild(0).getPoint(), new Point(9, 21));
		assertEquals(p2.getChild(1).getPoint(), new Point(21, 21));
		
		
		
		zaggerModel = new ZaggerPointModel();
		startPoint = new ZaggerPoint(new Point(0, 0));
		endPoint = new ZaggerPoint(new Point(15, 22));
		zaggerModel.setStart(startPoint);
		zaggerModel.setEnd(endPoint);
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(9, 9)));
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(21, 9)));
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(9, 21)));
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(21, 21)));
		
		linker.linkZaggerPoints(zaggerModel, gameModel);
		assertEquals(4, zaggerModel.getZaggerPointCount());
		
		p1 = zaggerModel.getZaggerPoint(0);
		p2 = zaggerModel.getZaggerPoint(1);
		p3 = zaggerModel.getZaggerPoint(2);
		p4 = zaggerModel.getZaggerPoint(3);
		
		
		startPoint = zaggerModel.getStart();
		endPoint = zaggerModel.getEnd();
		
		assertEquals(startPoint.getPoint(), new Point(0,0));
		
		assertEquals(startPoint.getChildCount(), 3);
		assertEquals(startPoint.getChild(0).getPoint(), new Point(9, 9));
		assertEquals(startPoint.getChild(1).getPoint(), new Point(21, 9));
		assertEquals(startPoint.getChild(2).getPoint(), new Point(9, 21));
		
		assertEquals(startPoint.getChild(0).getChildCount(), 0);
		assertEquals(startPoint.getChild(0).getPoint(), new Point(9, 9));
		//assertEquals(startPoint.getChild(0).getChild(0).getPoint(), new Point(21, 9));
		//assertEquals(startPoint.getChild(0).getChild(1).getPoint(), new Point(9, 21));
		
		assertEquals(startPoint.getChild(1).getChildCount(), 1);
		assertEquals(startPoint.getChild(1).getChild(0).getPoint(), new Point(21, 21));
		assertEquals(startPoint.getChild(1).getPoint(), new Point(21, 9));
		assertEquals(startPoint.getChild(2).getChildCount(), 2);
		assertEquals(startPoint.getChild(2).getPoint(), new Point(9, 21));
		assertEquals(startPoint.getChild(2).getChild(0).getPoint(), new Point(21, 21));
		assertEquals(startPoint.getChild(2).getChild(1).getPoint(), endPoint.getPoint());
		
		//assertEquals(startPoint.getChild(0).getChild(0).getChildCount(), 1);
		//assertEquals(startPoint.getChild(0).getChild(0).getPoint(), new Point(21, 9));
		
		//assertEquals(startPoint.getChild(0).getChild(1).getChildCount(), 2);
		//assertEquals(startPoint.getChild(0).getChild(1).getPoint(), new Point(9, 21));
		//assertEquals(startPoint.getChild(0).getChild(1).getChild(0).getPoint(), new Point(21, 21));
		//assertEquals(startPoint.getChild(0).getChild(1).getChild(1).getPoint(), endPoint.getPoint());
		
		assertEquals(startPoint.getChild(1).getChild(0).getChildCount(), 1);
	//	assertEquals(startPoint.getChild(1).getChild(0).getPoint(), new Point(9, 9));
		assertEquals(startPoint.getChild(1).getChild(0).getChild(0).getPoint(), endPoint.getPoint());
		
		assertEquals(startPoint.getChild(2).getChild(0).getChildCount(), 1);
		assertEquals(startPoint.getChild(2).getChild(0).getPoint(), new Point(21, 21));

		
		assertEquals(startPoint.getChild(2).getChild(1).getChildCount(), 0);
		assertEquals(startPoint.getChild(2).getChild(1).getPoint(), endPoint.getPoint());
		
		zaggerModel = new ZaggerPointModel();
		startPoint = new ZaggerPoint(new Point(0, 0));
		endPoint = new ZaggerPoint(new Point(10, 0));
		zaggerModel.setStart(startPoint);
		zaggerModel.setEnd(endPoint);
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(9, 9)));
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(21, 9)));
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(9, 21)));
		zaggerModel.addZaggerPoint(new ZaggerPoint(new Point(21, 21)));
		
		linker.linkZaggerPoints(zaggerModel, gameModel);
		assertEquals(4, zaggerModel.getZaggerPointCount());
		startPoint= zaggerModel.getStart();
		assertEquals(4, startPoint.getChildCount());
		
		
		
		
	}

}
