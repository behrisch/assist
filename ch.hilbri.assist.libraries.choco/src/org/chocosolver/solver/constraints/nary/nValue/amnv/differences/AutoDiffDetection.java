/**
 * Copyright (c) 2014,
 *       Charles Prud'homme (TASC, INRIA Rennes, LINA CNRS UMR 6241),
 *       Jean-Guillaume Fages (COSLING S.A.S.).
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * @author Jean-Guillaume Fages
 * @since 03/04/14
 * Created by IntelliJ IDEA.
 */
package org.chocosolver.solver.constraints.nary.nValue.amnv.differences;

import gnu.trove.map.hash.THashMap;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Propagator;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.Variable;

/**
 * automatic detection of binary disequalities and alldifferent constraints
 */
public class AutoDiffDetection implements D {

    //***********************************************************************************
    // VARIABLES
    //***********************************************************************************

    public static boolean DYNAMIC_ADDITIONS = false;

    protected Variable[] scope;

    //***********************************************************************************
    // CONSTRUCTORS
    //***********************************************************************************

    public AutoDiffDetection(Variable[] scope) {
        this.scope = scope;
    }

    //***********************************************************************************
    // METHODS
    //***********************************************************************************

    @Override
    public boolean mustBeDifferent(int i1, int i2) {
        // automatic detection of binary disequalities and alldifferent constraints
        if (DYNAMIC_ADDITIONS || scope[i1].getSolver().getEnvironment().getWorldIndex() <= 1) {
            for (Propagator p : scope[i1].getPropagators())
                if (p.isActive())
                    if (p.getClass().getName().contains("PropNotEqualX_Y") || p.getClass().getName().contains("PropAllDiff"))
                        for (Variable v : p.getVars())
                            if (v == scope[i2])
                                return true;
        }
        return false;
    }

    @Override
    public D duplicate(Solver solver, THashMap<Object, Object> identitymap) {
        int size = this.scope.length;
        IntVar[] aVars = new IntVar[size];
        for (int i = 0; i < size; i++) {
            this.scope[i].duplicate(solver, identitymap);
            aVars[i] = (IntVar) identitymap.get(this.scope[i]);
        }
        return new AutoDiffDetection(aVars);
    }

}
