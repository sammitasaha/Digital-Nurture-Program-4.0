package org.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Use mock in the service
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Step 3: Verify interaction with specific method
        verify(mockApi).getData();  // Verifies getData() was called
    }
}
