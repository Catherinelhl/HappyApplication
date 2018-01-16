package cn.catherine.happyapplication
import android.support.test.runner.AndroidJUnit4
import junit.framework.Test
import junit.framework.TestCase
import junit.framework.TestSuite
import junit.textui.TestRunner
import org.junit.runner.RunWith
import java.io.FileReader

/**
 * Created by catherine on 2017/12/18.
 */
@RunWith(AndroidJUnit4::class)
class FileReaderTester(name: String) : TestCase(name) {
    private lateinit var fileReader: FileReader

    override fun setUp() {
        super.setUp()
        try {
            fileReader = FileReader("data.txt")
        } catch (e: Throwable) {
            throw RuntimeException("this file is not found")

        }
    }

    override fun tearDown() {
        super.tearDown()
        try {
            fileReader.close()

        } catch (e: Throwable) {
            throw RuntimeException("error on closing the file")
        }
    }

    fun testRead() {
        var char: Char = '&'
        for (i in 0..4) {
            char = fileReader.read() as Char
            assert('d' == char)
        }
    }

    fun suite(): Test {
        println("suite")
        val testSuite = TestSuite()
        testSuite.addTest(FileReaderTester("testRead"))
        return testSuite
    }
//    @org.junit.Test
    fun main(args: Array<String>) {
        TestRunner.run(suite())
}

}
