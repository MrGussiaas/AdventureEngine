package scripts;

import static org.junit.Assert.*;

import java.awt.Point;

import objects.BarrierObject;
import objects.IBarrierObject;

import org.junit.Test;

import ui.ConcreteGameModel;
import ui.IGameModel;

public class ZaggerModelFactoryTest {

	@Test
	public void testCreateZaggerPointsFromModel() {
		IZaggerModelFactory factory = ZaggerModelFactory.getInstance();
		IGameModel model = new ConcreteGameModel();
		IZaggerPointModel zModel = factory.createZaggerPointsFromModel(model);
		assertEquals(0, zModel.getZaggerPointCount());
		
		model = new ConcreteGameModel();
		IBarrierObject barrierObject = new BarrierObject();
		barrierObject.setX(10);
		barrierObject.setWidth(10);
		barrierObject.setY(10);
		barrierObject.setHeight(10);
		model.addBarrier(barrierObject);
		
		zModel = factory.createZaggerPointsFromModel(model);
		assertEquals(4, zModel.getZaggerPointCount());
		IZaggerPoint z1 = zModel.getZaggerPoint(0);
		IZaggerPoint z2 = zModel.getZaggerPoint(1);
		IZaggerPoint z3 = zModel.getZaggerPoint(2);
		IZaggerPoint z4 = zModel.getZaggerPoint(3);
		
		assertEquals(z1.getPoint(), new Point(9, 9));
		assertEquals(z2.getPoint(), new Point(21, 9));
		assertEquals(z3.getPoint(), new Point(9, 21));
		assertEquals(z4.getPoint(), new Point(21, 21));
		
		model = new ConcreteGameModel();
		IBarrierObject barrier2 = new BarrierObject();
		barrier2.setX(15);
		barrier2.setHeight(3);
		barrier2.setY(11);
		barrier2.setWidth(10);
		
		model.addBarrier(barrierObject);
		model.addBarrier(barrier2);
		zModel = factory.createZaggerPointsFromModel(model);
		
		assertEquals(6, zModel.getZaggerPointCount());
		
		z1 = zModel.getZaggerPoint(0);
		z2 = zModel.getZaggerPoint(1);
		z3 = zModel.getZaggerPoint(2);
		z4 = zModel.getZaggerPoint(3);
		IZaggerPoint z5 = zModel.getZaggerPoint(4);
		IZaggerPoint z6 = zModel.getZaggerPoint(5);
		
		assertEquals(z1.getPoint(), new Point(9, 9));
		assertEquals(z2.getPoint(), new Point(21, 9));
		assertEquals(z3.getPoint(), new Point(9, 21));
		assertEquals(z4.getPoint(), new Point(21, 21));
		assertEquals(z5.getPoint(), new Point(26, 10));
		assertEquals(z6.getPoint(), new Point(26, 15));
		
		
		
		
	}

}
