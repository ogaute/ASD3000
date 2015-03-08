package controller;

import easylib.controller.Usecase;

/**
 * Denne klassen muliggjør bruk av nye Usecase utover 
 * Usecase i biblioteket som er inkludert.
 */

/*
 * Det er behov for en lett tilgjengelig liste 
 * over brukstilfeller og ikoner
 * Dette er den viktigste begrunnelsen 
 * for IActionlist og klassen Usecase.
 * 
 * IActionlist skal ha korte linjer. 
 * Hver actionklasse skal ha tekst som forenkler 
 * gjenkjennelsen.
 * Disse er de to viktigste grunnene til at klassen 
 * Usecase ikke inneholder all n�dvendig informasjon.  
 */

interface IActionlist {
	Usecase UNDO = new Usecase("tilbake", null);
	Usecase REDO = new Usecase("fremover", null);
    Usecase STARTNEW = new Usecase("Nytt Spill", null);
}
