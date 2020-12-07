package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;

public final class FigureExistencePostProcessor implements FigurePostProcessor {
    @Override
    public Figure process(Figure figure) throws FigureException {
        if(!figure.isPossibleToBuild()){
            throw new FigureNotExistException("impossible to create figure");
        }else{
            return figure;
        }
    }
}
