# MediTrash++++

![logo](https://user-images.githubusercontent.com/72397863/148071698-a12bc8a3-e961-429a-a194-d75cf039d728.png)



## Výzva

Legislativa vyžaduje evidovat zdravotnický odpad na straně lékařů.
Chceme vytvořit program na evidenci odpadu a na včasné, rychlé a snadné odesílání formulářů do systém  ISPOP. Cílem je snížit byrokratickou zátěž zdravotnického personálu v menších zdravotnických zařízeních s ohledem na příslušnou legislativu.

Pro malá zdravotnická zařízení je v pracovní době náročné ještě vést evidenci odpadů. Existuje katalog všech odpadů a je zdlouhavé v něm hledat konkrétní katalogová čísla zdravotnického odpadu.

Je potřeba zjednodušit proces evidování odpadů a vytvořit program s personalizovanou databází nejčastějších odpadů z konkrétního zdravotnického zařízení, tak aby si zaměstnanci jednou vyfiltrovali nejčastější odpady z jejich zařízení, průběžně případně mohli přidat další a poté už jen zadávali kolik ks konkrétního odpadu, který den vyhodili.

## Řešení

Naším řešením je jednoduchá a pohodlná desktop aplikace. Úkolem bylo vytvořit snadno použitelné rozhrání, které by však plně podporovalo požadovanou funkcionalitu. Kromě toho, design aplikace a databáze umožňuje bez obtíží zařazovat úpravy a nové funkce.

Program umožňuje přidávat nové uživatele prostřednictvím registrace a provádět jejich odstranění a úpravy jejich dat. Kromě toho je možné přidávat nové druhy odpadu a nakonec ukladat do DB jednotlivé záznamy o vyhazování odpadu. 

## Návrh databázového schématu

![Návrh databázového schématu](https://user-images.githubusercontent.com/72397863/154123147-3ccf9525-8930-47d1-a97c-6a6bfb4d6709.png)


## Použité technologie

1. **C#** - design aplikace.
2. **Java** - hlavní kód programu.
3. **MySQL** - návrh databáze.

## Připojení k databáze
```
package com.mediTrash.app.DBConnection;

public class Config {
    public final static String serverName = "147.230.21.34";
    public final static String dataBaseName = "DBS2021_NikitaEfimov";
    public final static String username = "student";
    public final static String password = "student";

}
```
```
package com.mediTrash.app.DBConnection;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class SQLConnect {

    protected SQLServerDataSource dataSource;

    public SQLConnect() {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName(Config.serverName);
        dataSource.setDatabaseName(Config.dataBaseName);
        dataSource.setUser(Config.username);
        dataSource.setPassword(Config.password);
    }
}
```
## SQL Injection
```
public void userNameChanger(String usernameOld, String usernameNew) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = ("UPDATE Uzivatel SET login=? WHERE login=?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,usernameNew);
            preparedStatement.setString(2,usernameOld);
            preparedStatement.executeUpdate();
        }
    }
```
