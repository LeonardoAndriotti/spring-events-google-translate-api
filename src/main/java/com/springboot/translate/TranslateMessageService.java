package com.springboot.translate;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class TranslateMessageService {

    private static final String PT = "pt";

    public String translate(String code, String text) {
        Translate translate = TranslateOptions.newBuilder().setCredentials(credentials()).build().getService();

        Translation translation =
                translate.translate(
                        text,
                        Translate.TranslateOption.sourceLanguage(code),
                        Translate.TranslateOption.targetLanguage(PT));

        return translation.getTranslatedText();
    }

    private GoogleCredentials credentials() {
        GoogleCredentials credentials = null;
        try {
            credentials = GoogleCredentials.fromStream(new FileInputStream("PATH"))
                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return credentials;
    }
}
