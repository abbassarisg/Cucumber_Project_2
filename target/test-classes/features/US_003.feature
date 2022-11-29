@Smoke

  Feature: US003 Registration sayfasında guclu sifre girilmeli ve
           "Password strength" seviyeleri gorulmelidir.

Background: Ortak adimlar

    Given Belirtilen Url'e gidilir
    Then Kullanici sayfada sag usste bulunan kisi iconuna tiklar ve sign in ve register segmesi acilir
    And Acilan kutucukta register secenegini tiklanir
    And Acilanin Register sayfasi oldugu dogrulanir.

    Scenario: TC_001 Daha guclu sifre en az 1 kucuk  harf olmali ve"Password strength" seviyesinin degistigi gorulmeli
    Then Password kismina "123456a" girilir Password streght renk seviyesini degisti test edilir
      And Acilan sayfa kapatilir


    Scenario: TC_002 Sifre en az bir buyuk harf icermeli ve "Password strength" seviyesinin degistigi gorulmeli
    Then Password kismina "123456A" girilir Password streght renk seviyesini degisti test edilir

    Scenario: TC_003 Sifre en az bir rakam icermeli ve "Password strenght" seviyesinin degistigi gorulmeli
    Then Password kismina "aaaaaa1" girilir Password streght renk seviyesini degisti test edilir
      And Acilan sayfa kapatilir

    Scenario: TC_004 Sifre en az bir ozel karakter icermeli ve "Password strenght" seviyesinin degistigi gorulmeli
    Then Password kismina "aaaaaa*" girilir Password streght renk seviyesini degisti test edilir
      And Acilan sayfa kapatilir

    Scenario: TC_005 Guclu bir parola icin sifre en az 7 karakterden olusmalidir.#Negatif test
    Then Password kismina "aaaA1*" girilir Password streght renk seviyesini degisti test edilir
      And Acilan sayfa kapatilir

   Scenario: TC_006 Guclu bir parola icin sifre en az 7 karakterden olusmalidir
   Then Password kismina "aaaaA1*" girilir Password streght renk seviyesini degisti test edilir
     And Acilan sayfa kapatilir

    Scenario: TC_007 Kullanici parolanin kabulu icin en az 4 karakter girilmelidir
    Then Password kismina "A1*" girilir Password streght renk seviyesini degisti test edilir
      And Acilan sayfa kapatilir

      Scenario Outline: TC_008 Kullanici icerisinde kucuk harf, buyuk harf ve rakam icermeyen sifre (Ascii code 128-149 ve 151-174)
                        gonderir ve acceptance criteria nin aksine(Bug oldugunun tespiti) Password Strenght seviyesindeki kutucuklarinin
                        hepsinin renginin degistigi tespit edilir.

        Given : Kullanici Ascii Code "<Ascii Code araligi>" den sonraki karakterkerden olusan bir sifre gonderir
        Then  : Kullanici Password Strenght "<Renk seviyesi>" degistigini test eder

        Examples: Test data
                  |Ascii Code araligi|        Renk seviyesi             |
                  |128-149|background-color: rgb(0, 255, 0);|
                  |151-174 |background-color: rgb(0, 255, 0);|





