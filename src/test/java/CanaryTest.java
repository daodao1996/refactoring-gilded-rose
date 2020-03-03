import com.gildedrose.TexttestFixture;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CanaryTest {

    @Test
    public void should_be_able_to_use_guava_capabilities() throws IOException {
        String src = Files.toString(new File("src/test/java/com/gildedrose/baseline.txt"), UTF_8);
        assertThat(TexttestFixture.generateText(), is(src));
    }
}
