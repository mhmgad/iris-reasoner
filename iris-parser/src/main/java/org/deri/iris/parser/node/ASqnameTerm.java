/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.*;

@SuppressWarnings("nls")
public final class ASqnameTerm extends PTerm
{
    private TTSq _tSq_;

    public ASqnameTerm()
    {
        // Constructor
    }

    public ASqnameTerm(
        @SuppressWarnings("hiding") TTSq _tSq_)
    {
        // Constructor
        setTSq(_tSq_);

    }

    @Override
    public Object clone()
    {
        return new ASqnameTerm(
            cloneNode(this._tSq_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASqnameTerm(this);
    }

    public TTSq getTSq()
    {
        return this._tSq_;
    }

    public void setTSq(TTSq node)
    {
        if(this._tSq_ != null)
        {
            this._tSq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tSq_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tSq_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tSq_ == child)
        {
            this._tSq_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tSq_ == oldChild)
        {
            setTSq((TTSq) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}