package de.devsnx.survivalgames.manager.other;

public enum LanguageType {

    de_DE, en_EN, fr_FR;

    public static LanguageType getLanguageByName(String name) {
        LanguageType[] arrayOfLanguages;
        int j = (arrayOfLanguages = values()).length;
        for (int i = 0; i < j; i++) {
            LanguageType language = arrayOfLanguages[i];
            if (language.name().equalsIgnoreCase(name)) {
                return language;
            }
        }
        return null;
    }
}
