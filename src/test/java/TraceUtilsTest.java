import cn.yuanyang.parser.Trace;
import cn.yuanyang.parser.util.MethodUtils;
import cn.yuanyang.parser.util.TraceUtils;
import org.junit.jupiter.api.Test;

public class TraceUtilsTest {

    @Test
    public void testGetContentStr() {
        MethodUtils.init("C:\\Users\\wps\\Downloads\\overseaRelease\\methodMapping.txt");
        String traceStr = "tag[Trace_EvilMethod]type[0];key[null];content[{\"machine\":\"MIDDLE\",\"cpu_app\":0,\"mem\":3948359680,\"mem_free\":2038040,\"detail\":\"NORMAL\",\"cost\":3784,\"usage\":\"29.45%\",\"scene\":\"cn.wps.moffice.main.local.HomeRootActivity\",\"stack\":\"0,1048574,1,3784\\n1,355464,1,2976\\n2,355471,1,2976\\n3,355593,1,537\\n4,432879,1,537\\n5,416619,1,92\\n5,432876,1,445\\n6,374669,1,146\\n7,374670,1,146\\n8,374676,1,146\\n9,406796,1,125\\n10,201735,1,85\\n3,413302,1,2215\\n4,413306,1,2167\\n5,151192,1,2141\\n6,151204,1,2141\\n7,152831,1,2141\\n8,152876,1,2108\\n1,410832,1,648\\n2,427727,1,648\\n3,427728,1,626\\n4,332202,1,117\\n5,332218,1,117\\n4,427730,1,348\\n5,427731,1,327\\n6,443089,1,327\\n7,443090,1,327\\n8,339416,1,327\\n9,412271,1,321\\n10,412273,1,136\\n\",\"stackKey\":\"152876|\",\"tag\":\"Trace_EvilMethod\",\"process\":\"cn.wps.moffice_eng\",\"time\":1642448894887}]";
        Trace trace = TraceUtils.parseItem(traceStr);
        System.out.println(traceStr);
    }
}
