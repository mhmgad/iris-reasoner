/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.*;

@SuppressWarnings("nls")
public final class TTPreDaytimeduration extends Token
{
    public TTPreDaytimeduration()
    {
        super.setText("_daytimeduration");
    }

    public TTPreDaytimeduration(int line, int pos)
    {
        super.setText("_daytimeduration");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTPreDaytimeduration(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTPreDaytimeduration(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTPreDaytimeduration text.");
    }
}