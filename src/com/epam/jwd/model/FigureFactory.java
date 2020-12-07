package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

public class FigureFactory {
    public static Figure createFigure(Point... points) throws FigureNotExistException {
        final FigureExistencePostProcessor postProcessor = new FigureExistencePostProcessor();
        Figure figure = null;
        switch (points.length){
            case 2:
                figure = new Line(points);
                break;
            case 3:
                figure = new Triangle(points);
                break;
            case 4:
                figure = new Square(points);
                break;
            case 5:
            case 6:
                figure = new MultiAngleFigure(points);
                break;
            default:
                /*System.out.println("inappropriate amount of points");*/
                throw new FigureNotExistException("inappropriate amount of points");
        }
        try {
            return postProcessor.process(figure);
        } catch (FigureException e) {
            throw new FigureNotExistException("impossible to create figure");
        }
    }
}
