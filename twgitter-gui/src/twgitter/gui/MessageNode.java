package twgitter.gui;

import javafx.scene.Node;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.PGNode;

public class MessageNode extends Node {
	@Override
	protected boolean impl_computeContains(double arg0, double arg1) {
		return false;
	}

	@Override
	public BaseBounds impl_computeGeomBounds(BaseBounds arg0, BaseTransform arg1) {
		return null;
	}

	@Override
	protected PGNode impl_createPGNode() {
		return null;
	}

	@Override
	public Object impl_processMXNode(MXNodeAlgorithm arg0,MXNodeAlgorithmContext arg1) {
		return null;
	}

}
