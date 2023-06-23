package com.acme;

import org.junit.Test;

import static org.junit.Assert.*;

public class BondCalculatorTest {

    @Test
    public void calculateBondInstalmentTest1() {
        BondCalculator bond = new BondCalculator(500000, 10.0f, (byte) 20);
        assertEquals(bond.calculateBondInstalment(), 4825.109919340479, 0.000000000);

        assertEquals(bond.calculateBondInstalment(), 4825.109919340479, 0.00);

    }

    @Test
    public void calculateBondInstalmentTest2() {
        BondCalculator bond = new BondCalculator(1000, 10.0f, (byte) 20);
        assertEquals(bond.calculateBondInstalment(), 9.650219838680957, 0.00);

    }

    @Test
    public void calculateBondInstalmentTest3() {
        BondCalculator bond = new BondCalculator(100000, 10.0f, (byte) 20);
        assertEquals(bond.calculateBondInstalment(), 965.0219838680957, 0.00);

    }

    @Test
    public void calculateBondInstalmentTest4() {
        BondCalculator bond = new BondCalculator(500000, 27.0f, (byte) 25);
        assertEquals(bond.calculateBondInstalment(), 11264.213946781287, 0.00);

    }

    @Test
    public void calculateBondInstalmentTest5() {
        BondCalculator bond = new BondCalculator(100000, 30.0f, (byte) 30);
        assertEquals(bond.calculateBondInstalment(), 2500.34471399802, 0.00);

    }

    @Test
    public void calculateBondInstalmentTest6() {
        BondCalculator bond = new BondCalculator(100000, 1.0f, (byte) 1);
        assertEquals(bond.calculateBondInstalment(), 8377.9527204548, 0.00);

    }

    @Test
    public void calculateBondInstalmentTest7() {
        BondCalculator bond = new BondCalculator(1000, 30.0f, (byte) 1);
        assertEquals(bond.calculateBondInstalment(), 97.48720733901936, 0.00);

    }

    @Test
    public void calculateBondInstalmentTest8() {
        BondCalculator bond = new BondCalculator(90000, 29.78f, (byte) 4);
        assertEquals(bond.calculateBondInstalment(), 3229.036092687629, 0.00);

    }

    @Test
    public void calculateBondInstalmentTest9() {
        BondCalculator bond = new BondCalculator(3930, 29.78f, (byte) 4);
        assertEquals(bond.calculateBondInstalment(), 141.00124271402646, 0.00);
    }

    @Test
    public void calculateBondInstalmentTest10() {
        assertThrows(IllegalArgumentException.class, () -> {
            BondCalculator bond = new BondCalculator(-500000, 29.0f, (byte) 14);
        });
    }

    @Test
    public void calculateBondInstalmentTest11() {
        assertThrows(IllegalArgumentException.class, () -> {
            BondCalculator bond = new BondCalculator(50, 69.0f, (byte) 47);
        });
    }

    @Test
    public void calculateBondInstalmentTest12() {
        assertThrows(IllegalArgumentException.class, () -> {
            BondCalculator bond = new BondCalculator(6000, 30.01f, (byte) 22);
        });
    }

    @Test
    public void calculateBondInstalmentTest13() {
        assertThrows(IllegalArgumentException.class, () -> {
            BondCalculator bond = new BondCalculator(20000, 9.00f, (byte) 31.1);
        });
    }

    @Test
    public void calculateBondInstalmentTest14() {

        assertThrows(IllegalArgumentException.class, () -> {
            BondCalculator bond = new BondCalculator(2000000, 20.00f, (byte) 16);
        });
    }

    @Test
    public void calculateBondInstalmentTest15() {

        assertThrows(IllegalArgumentException.class, () -> {
            BondCalculator bond = new BondCalculator(0, 0.0f, (byte) 0);
        });

    }

    @Test
    public void calculateBondInstalmentTest16() {

        assertThrows(IllegalArgumentException.class, () -> {
            BondCalculator bond = new BondCalculator(8000, -0.01f, (byte) 10);
        });

    }

    @Test
    public void calculateBondInstalmentTest17() {

        assertThrows(IllegalArgumentException.class, () -> {
            BondCalculator bond = new BondCalculator(6000, 10.0f, (byte) -1);
        });

    }

    @Test
    public void calculateBondInstalmentTest18() {

        assertThrows(IllegalArgumentException.class, () -> {
            BondCalculator bond = new BondCalculator(-22990, 16.0f, (byte) 9);
        });

    }
}
