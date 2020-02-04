package de.snx.survivalgames.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.util.UUIDTypeAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UUIDFetcher {

    public static final long FEBRUARY_2015 = 1422748800000L;

    private static Gson gson = (new GsonBuilder()).registerTypeAdapter(UUID.class, new UUIDTypeAdapter()).create();

    private static final String UUID_URL = "https://api.mojang.com/users/profiles/minecraft/%s?at=%d";

    private static final String NAME_URL = "https://api.mojang.com/user/profiles/%s/names";

    private static Map<String, UUID> uuidCache = new HashMap();

    private static Map<UUID, String> nameCache = new HashMap();

    private static ExecutorService pool = Executors.newCachedThreadPool();

    private String name;

    private UUID id;

    public static void getUUID(final String name, Consumer<UUID> action) {
        pool.execute(new Acceptor<UUID>(action) {
            public UUID getValue() {
                return UUIDFetcher.getUUID(name);
            }
        });
    }

    public static UUID getUUID(String name) {
        return getUUIDAt(name, System.currentTimeMillis());
    }

    public static void getUUIDAt(final String name, final long timestamp, Consumer<UUID> action) {
        pool.execute(new Acceptor<UUID>(action) {
            public UUID getValue() {
                return UUIDFetcher.getUUIDAt(name, timestamp);
            }
        });
    }

    public static UUID getUUIDAt(String name, long timestamp) {
        name = name.toLowerCase();
        if (uuidCache.containsKey(name))
            return uuidCache.get(name);
        try {
            HttpURLConnection connection = (HttpURLConnection)(new URL(String.format("https://api.mojang.com/users/profiles/minecraft/%s?at=%d", new Object[] { name, Long.valueOf(timestamp / 1000L) }))).openConnection();
            connection.setReadTimeout(5000);
            UUIDFetcher data = (UUIDFetcher)gson.fromJson(new BufferedReader(new InputStreamReader(connection.getInputStream())), UUIDFetcher.class);
            uuidCache.put(name, data.id);
            nameCache.put(data.id, data.name);
            return data.id;
        } catch (Exception exception) {
            return null;
        }
    }

    public static void getName(final UUID uuid, Consumer<String> action) {
        pool.execute(new Acceptor<String>(action) {
            public String getValue() {
                return UUIDFetcher.getName(uuid);
            }
        });
    }

    public static String getName(UUID uuid) {
        if (nameCache.containsKey(uuid))
            return nameCache.get(uuid);
        try {
            HttpURLConnection connection = (HttpURLConnection)(new URL(
                    String.format("https://api.mojang.com/user/profiles/%s/names", new Object[] { UUIDTypeAdapter.fromUUID(uuid) }))).openConnection();
            connection.setReadTimeout(5000);
            UUIDFetcher[] nameHistory = (UUIDFetcher[])gson.fromJson(new BufferedReader(
                            new InputStreamReader(connection.getInputStream())),
                    UUIDFetcher[].class);
            UUIDFetcher currentNameData = nameHistory[nameHistory.length - 1];
            uuidCache.put(currentNameData.name.toLowerCase(), uuid);
            nameCache.put(uuid, currentNameData.name);
            return currentNameData.name;
        } catch (Exception exception) {
            return null;
        }
    }

    public static abstract class Acceptor<T> implements Runnable {
        private UUIDFetcher.Consumer<T> consumer;

        public Acceptor(UUIDFetcher.Consumer<T> consumer) {
            this.consumer = consumer;
        }

        public abstract T getValue();

        public void run() {
            this.consumer.accept(getValue());
        }
    }

    public static interface Consumer<T> {
        void accept(T param1T);
    }
}