import com.ruoyi.fac.domain.FacDeviceMetaTemper;
import com.ruoyi.fac.service.IFacDeviceMetaTemperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.ruoyi.common.utils.PageUtils.startPage;

/**
 * @author lee
 * @date 2022-12-27 20:21:39
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApplication.class)
public class temperTest {


        @Autowired
        private IFacDeviceMetaTemperService facDeviceMetaTemperService;

        @Test
        public void test() throws Exception{
            startPage();
            List<FacDeviceMetaTemper> list = facDeviceMetaTemperService.selectFacDeviceMetaTemperList(new FacDeviceMetaTemper());

            System.out.println(list);
            //            return getDataTable(list);
        }

}
