package com.hdsx.hmglyh.gis.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.PrecisionModel;

public class PolygonTransfor {

	// GeometryFactory geof4326=new GeometryFactory(10000000d, 4326);
	GeometryFactory geof4326 = new GeometryFactory(new PrecisionModel(1E7),
			4326);
	GeometryFactory geof90013 = new GeometryFactory(new PrecisionModel(1E3),
			90013);

	public Polygon trans2Polygon(byte[] bytes) throws IOException {

		ByteBuffer buffer = ByteBuffer.wrap(bytes);
		buffer.order(ByteOrder.LITTLE_ENDIAN);

		int type = buffer.getInt();
		int count = buffer.getInt();
		double[] corxs = new double[count];
		double[] corys = new double[count];
		for (int i = 0; i < count; i++) {
			corxs[i] = buffer.getDouble();
		}
		for (int i = 0; i < count; i++) {
			corys[i] = buffer.getDouble();
		}
		Coordinate[] cors = new Coordinate[count+1];
		for (int i = 0; i < count; i++) {
			cors[i] = new Coordinate(corxs[i], corys[i]);
		}
		cors[count]=new Coordinate(corxs[0], corys[0]);
		if (corxs[0] > 180)
			return geof90013.createPolygon(cors);
		else
			return geof4326.createPolygon(cors);

	}
	
	public LineString trans2Polyline(byte[] bytes) throws IOException {

		ByteBuffer buffer = ByteBuffer.wrap(bytes);
		buffer.order(ByteOrder.LITTLE_ENDIAN);

		int type = buffer.getInt();
		int count = buffer.getInt();
		double[] corxs = new double[count];
		double[] corys = new double[count];
		for (int i = 0; i < count; i++) {
			corxs[i] = buffer.getDouble();
		}
		for (int i = 0; i < count; i++) {
			corys[i] = buffer.getDouble();
		}
		Coordinate[] cors = new Coordinate[count];
		for (int i = 0; i < count; i++) {
			cors[i] = new Coordinate(corxs[i], corys[i]);
		}
	
		if (corxs[0] > 180)
			return geof90013.createLineString(cors);
		else
			return geof4326.createLineString(cors);

	}

}
