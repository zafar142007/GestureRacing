package com.zafar.util;

import java.awt.image.BufferedImage;

//import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
//import org.apache.commons.math3.linear.Array2DRowRealMatrix;
//import org.apache.commons.math3.linear.DecompositionSolver;
//import org.apache.commons.math3.linear.LUDecomposition;
//import org.apache.commons.math3.linear.RealMatrix;
//import org.opencv.core.Core;

public class Trial {
	/*
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	private static BufferedImage findDifferenceImage(BufferedImage image,
			BufferedImage previousImage, double threshold) {

		double differenceValue = 0;
		BufferedImage im = new BufferedImage(image.getWidth(),
				image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
		double difference[][] = new double[image.getWidth()][image.getHeight()];
		for (int x = 0; x < image.getWidth(); ++x)
			for (int y = 0; y < image.getHeight(); ++y) {
				differenceValue = image.getRGB(x, y)
						- previousImage.getRGB(x, y);
				if (differenceValue < threshold)
					im.setRGB(x, y, 0);

				else {
					im.setRGB(x, y, (255 << 16) + (255 << 8) + 255);
				}
			}
		return im;
	}



	public static double[][] makeGray(BufferedImage img) {
		double[][] grayScale = new double[img.getWidth()][img.getHeight()];
		for (int x = 0; x < img.getWidth(); ++x)
			for (int y = 0; y < img.getHeight(); ++y) {
				int rgb = img.getRGB(x, y);
				int r = (rgb >> 16) & 0xFF;
				int g = (rgb >> 8) & 0xFF;
				int b = (rgb & 0xFF);

				// int grayLevel = (r + g + b) / 3;
				int grayLevel = (int) (0.2126 * r + 0.7152 * g + 0.0722 * b);
				// int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;
				grayScale[x][y] = grayLevel;
			}
		return grayScale;
	}

	private static Vector2D[][] findOpticalFlowMatrix(BufferedImage image,
			BufferedImage previousImage) {
		// https://en.wikipedia.org/wiki/Optical_flow
		double Ix = 0, Iy = 0, It = 0, Ixisquared = 0, Iyisquared = 0, IxiIyi = 0, IxiIti = 0, IyiIti = 0, ii = 0, jj = 0, tt = 0;
		int x = 0, y = 0, i = 0, j = 0;
		Vector2D[][] opticalFlow = new Vector2D[image.getWidth()][image
				.getHeight()];
		for (x = 2; x < image.getWidth() - 2; x++) {
			for (y = 2; y < image.getHeight() - 2; y++) {
				Ix = getIx(image, x, y);
				Iy = getIy(image, x, y);
				It = (image.getRGB(x, y) - previousImage.getRGB(x, y));
				// Using lucas kanade method
				// http://docs.opencv.org/3.1.0/d7/d8b/tutorial_py_lucas_kanade.html#gsc.tab=0
				Ixisquared = 0;
				Iyisquared = 0;
				IxiIyi = 0;
				IxiIti = 0;
				IyiIti = 0;
				for (i = x - 1; i < x + 1; i++)
					for (j = y - 1; j < y + 1; j++) {
						ii = getIx(image, i, j);
						jj = getIy(image, i, j);
						Ixisquared += (ii * ii);
						Iyisquared += (jj * jj);
						IxiIyi += (ii * jj);
						IxiIti += (ii * (image.getRGB(i, j) - previousImage
								.getRGB(i, j)));
						IyiIti += (jj * (image.getRGB(i, j) - previousImage
								.getRGB(i, j)));
					}
				double matrix[][] = { { Ixisquared, IxiIyi },
						{ IxiIyi, Iyisquared } };
				double vector[][] = { { IxiIti }, { IyiIti } };

				RealMatrix a = new Array2DRowRealMatrix(matrix);
				DecompositionSolver solver = new LUDecomposition(a).getSolver();
				// System.out.println(a);
				RealMatrix flow = new Array2DRowRealMatrix(matrix);
				if (solver.isNonSingular())
					flow = solver.getInverse().multiply(
							new Array2DRowRealMatrix(vector));

				opticalFlow[x][y] = new Vector2D(flow.getEntry(0, 0),
						flow.getEntry(1, 0));

			}
		}
		return opticalFlow;

	}

	public static double getIx(BufferedImage image, int x, int y) {
		return ((image.getRGB(x + 1, y) - image.getRGB(x, y)) + (image.getRGB(
				x, y) - image.getRGB(x - 1, y))) / 2;
	}

	public static double getIy(BufferedImage image, int x, int y) {
		return ((image.getRGB(x, y + 1) - image.getRGB(x, y)) + (image.getRGB(
				x, y) - image.getRGB(x, y - 1))) / 2;

	}
*/
}
