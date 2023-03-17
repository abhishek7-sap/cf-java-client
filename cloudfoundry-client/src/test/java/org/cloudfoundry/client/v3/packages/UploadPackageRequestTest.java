/*
 * Copyright 2013-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.client.v3.packages;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class UploadPackageRequestTest {

    private static final Path TEST_PACKAGE = Paths.get("/");

    @Test(expected = IllegalStateException.class)
    public void neitherBitsNorResources() {
        UploadPackageRequest.builder()
            .packageId("test-package-id")
            .build();
    }

    @Test(expected = IllegalStateException.class)
    public void noPackageId() {
        UploadPackageRequest.builder()
            .bits(TEST_PACKAGE)
            .build();
    }

    @Test
    public void valid() {
        UploadPackageRequest.builder()
            .bits(TEST_PACKAGE)
            .packageId("test-package-id")
            .build();
    }

}
