/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import clases.BingoExceptions;
import clases.Carton;

/**
 *
 * @author atrias
 */
public interface IFigura {
    public abstract boolean cumpleFigura(Carton carton) throws BingoExceptions;
}
