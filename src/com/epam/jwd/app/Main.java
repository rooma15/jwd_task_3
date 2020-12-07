package com.epam.jwd.app;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureFactory;
import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.PerimeterStrategy;


public class Main {

    public static void meth(int var){
        var = 5;
        System.out.println(var);
    }
    interface test{
        int a = 4;
    }

    public static String f(int a){
        return a ==3 ? "3" : a == 4 ? "4" : "5";
    }

    public static void main(String[] args) {
        int var = 4;

        
        meth(var);
        System.out.println("E: " + (var + var));
        Point[] points = new Point[6];
        points[0] = new Point(1, 2);
        points[1] = new Point(3, 4);
        points[2] = new Point(5, 8);
        points[3] = new Point(1, 1);
        points[4] = new Point(4, 3);
        points[5] = new Point(8, 3);
        Figure fiveAngle = null;
        try {
            fiveAngle = FigureFactory.createFigure(
                    points[0],
                    points[1],
                    points[2],
                    points[3],
                    points[4]
            );
        } catch (FigureNotExistException e) {
            System.out.println(e.getMessage());
        }
        Figure sixAngle = null;
        try {
            sixAngle = FigureFactory.createFigure(points);
        } catch (FigureNotExistException e) {
            System.out.println(e.getMessage());
        }

        Figure tr = null;
        try{
            tr = FigureFactory.createFigure(points[0], points[1], points[2]);
            System.out.println(tr);
        }catch (FigureNotExistException e){
            System.out.println(e.getMessage());
        }

    }
}