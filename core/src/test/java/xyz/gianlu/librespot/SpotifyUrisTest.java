package xyz.gianlu.librespot;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import xyz.gianlu.librespot.mercury.model.EpisodeId;
import xyz.gianlu.librespot.mercury.model.TrackId;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Gianlu
 */
class SpotifyUrisTest {

    private static void testTrackId(@NotNull String uri) {
        TrackId id = TrackId.fromUri(uri);
        assertEquals(uri, id.toSpotifyUri());
        assertEquals(32, id.hexId().length());
    }

    private static void testEpisodeId(@NotNull String uri) {
        EpisodeId id = EpisodeId.fromUri(uri);
        assertEquals(uri, id.toSpotifyUri());
        assertEquals(32, id.hexId().length());
    }

    @Test
    void test() {
        for (String uri : Arrays.asList("spotify:track:00yinrzqPZKA2vbnwnn3hS", "spotify:track:0FknXlaOeXD7Vto1Hx9wtP",
                "spotify:track:6r027Faonff84hxFMjMbIH", "spotify:track:0000000000000000000000"))
            testTrackId(uri);

        for (String uri : Arrays.asList("spotify:episode:04XPBNQX6S9bhKsvA7xhFK", "spotify:episode:0000000000000000000000"))
            testEpisodeId(uri);
    }
}
