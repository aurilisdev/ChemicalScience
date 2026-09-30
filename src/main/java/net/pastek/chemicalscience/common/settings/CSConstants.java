package net.pastek.chemicalscience.common.settings;

import voltaic.api.configuration.Configuration;
import voltaic.api.configuration.DoubleValue;

@Configuration(name = "ChemicalScience")
public class CSConstants {

    @DoubleValue(def = 90.0)
    public static double ORGANICSOLARPANEL_AMPERAGE = 90.0;

    @DoubleValue(def = 550.0)
    public static double FUEL_CELL_JOULES_PER_TICK = 550.0;


}