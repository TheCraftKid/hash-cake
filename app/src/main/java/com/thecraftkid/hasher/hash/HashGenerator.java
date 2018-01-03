package com.thecraftkid.hasher.hash;

import android.support.annotation.NonNull;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * A class that generates MD5, SHA1, and SHA256 hashes.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public final class HashGenerator {

    private HashGenerator() {
    }

    /**
     * Returns a MD5 hash of the given input.
     */
    @NonNull
    public static String generateMD5(String input) {
        return decodeBytes(DigestUtils.md5(input));
    }

    /**
     * Returns a SHA1 hash of the given input.
     */
    @NonNull
    public static String generateSHA1(String input) {
        return decodeBytes(DigestUtils.sha1(input));
    }

    /**
     * Returns a SHA256 hash of the given input.
     */
    @NonNull
    public static String generateSHA256(String input) {
        return decodeBytes(DigestUtils.sha256(input));
    }

    @NonNull
    private static String decodeBytes(byte[] bytes) {
        return new String(Hex.encodeHex(bytes));
    }
}
