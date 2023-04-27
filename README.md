# olioprojekti

Esittelyvideo löytyy youtubesta: **LINKKI**

Projekti on toteutettu yksin.

Perusominaisuuksien lisäksi ekstaominaisuuksia ovat lutemonien omat kuvakkeet, lutemonien listauksessa käytetty recycleview sekä pieni satunnaisuus lutemonien treenauksessa ja taisteluissa.

Appi avautuu kotinäytölle josta voi siirtyä luomaan, listaamaan, siirtämään, treenaamaan ja taisteluttamaan lutemoneja. 

Lutemonia luodessa hankitaan Storage-luokan instanssi jossa on lista lutemoneista johon luotu lutemon lisätään valitun tyypin perusteella. Tyyppejä on viisi ja lutemonille voi antaa oman nimen.

Lutemonien listausruudussa hankitaan Storage-instanssin kautta lista kaikista lutemoneista ja listataan kaikkien lutemonien nimi, tyyppi, hyökkäys, puolustus, kokemus, sekä elämäpisteet hyödyntäen recycleviewiä.

Lutemonien siirtämisnäytössä voi nappia painamalla valita missä sijaitsevia lutemoneja haluaa siirtää. Napin painaminen aloittaa loopin joka etsii lutemonin sijainti-attribuutin perusteella halutut lutemonit ja listaa ne omina checkbox-elementteinään. Näistä voi valita halutut lutemonin ja alempanta radio-napin mihin lutemonit halutaan siirtää. Siirtonappia painaessa kaikkien valittujen lutemonien sijainti-attribuutti vaihdetaan haluttuun sijaintiin.

Treenausnäytössä listataan siirtämisnäytön tapaan kaikki sijannin perusteella sopivat lutemonit radio-nappeina. Näistä voi valita yhden lutemonin kerrallaan jota treenata. Nappia painaessa haluttu lutemon  haetaan Storage-luokasta ja sen hyökkäys- ja puolustuskykyjä parannetaan kokemuspisteiden mukaan. Parannuksen määrässä on jonkin verran sattumaa sillä lutemon voi saada pisteitä väliltä (0-2) * kokemuspisteet).

Taistelunäytössä näytetään muiden näyttöjen tapaan ne lutemonit jotka on siirretty taistelemaan. Näistä tulee valita kaksi lutemonia ja nappia painamalla alkaa taistelu jolloin valitut lutemonit haetaan Storage-luokasta instanssin avulla. Taistelussa lasketaan vuorotellen lutemonien hyökkäykset toisiaan vastaan. Hyökkäysten suuruudessa on  treenaamisen tavoin pieni määrä sattumaa. Voittava lutemon palautetaan takaisin Storage-luokkaan ja sen elämäpisteet palaavat maksimiin sekä kokemuspisteet nousevat yhdellä.

Luokkakaavio: <img width="764" alt="image" src="https://user-images.githubusercontent.com/107469352/234818060-39e534e9-5625-49f8-8e34-5927711e7c1c.png">
Luettavuuden takia Lutemon-luokasta puuttuu get ja set metodit luokan attribuuteille.
