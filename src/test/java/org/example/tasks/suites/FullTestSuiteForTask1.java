package org.example.tasks.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("org.example.tasks")
@IncludeTags("full_task1")
public class FullTestSuiteForTask1 {

}
