/*
 * Piirtää hirsipuuta
 */
package ay_projekti;

/**
 * @strann
 */

public class TikkuUkko {
    
    /**
     * Pelataan Hirsipuuta
     * @param yrityksia ottaa paramaterina jäljellä olevien yritysten lukumäärän
     * AE: maksMaara != kirjain 
     * Palauttaa merkkijonon, josta muodostuu hirsipuu
     */
    public String piirra(int yrityksia) {
        switch(yrityksia){
 
            case 4:
                return ("    |\n    |\n    |\n    |\n    |\n    |\n__|__");

            case 3:
                return ("   ____________\n    |\n    |\n    |\n    |\n    |\n    |\n__|__");

            case 2:
                return ("   ____________\n    |                    _|_\n    |                  /        \\\n    |                  \\ _ _ /\n    |\n    |\n    |\n__|__");

            case 1:
                return ("   ____________\n    |                    _|_\n    |                  /        \\\n    |                  \\ _ _ /\n    |                    _|_\n    |\n    |\n__|__");
                
            case 0:
                return ("   ____________\n    |                    _|_\n    |                  /        \\\n    |                  \\ _ _ /\n    |                    _|_\n    |                      |\n    |                     /  \\\n__|__");
            
            default:
                return "";
	}
    }
}

/*
   ____________
   |          _|_
   |         /   \\
   |        \\_ _/
   |          _|_
   |           |
   |          / \\
___|___
*/
