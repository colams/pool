package cn.colams.biz.business;

import cn.colams.dal.entity.BasicConfig;
import cn.colams.dal.entity.BasicConfigExample;
import cn.colams.dal.mapper.extension.BasicConfigExtensionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasicConfigBiz {

    private BasicConfigExtensionMapper basicConfigExtensionMapper;

    public BasicConfigBiz(BasicConfigExtensionMapper basicConfigExtensionMapper) {
        this.basicConfigExtensionMapper = basicConfigExtensionMapper;
    }

    public String getConfigValue(String configKey) {
        BasicConfigExample basicConfigExample = new BasicConfigExample();
        BasicConfigExample.Criteria criteria = basicConfigExample.createCriteria();
        criteria.andConfigKeyEqualTo(configKey);
        List<BasicConfig> configs = basicConfigExtensionMapper.selectByExample(basicConfigExample);
        return Optional.ofNullable(configs).map(e -> e.get(0).getConfigKey()).orElse("");
    }

}
