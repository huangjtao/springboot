package com.mtl.system.service.impl;


import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;
import com.mtl.common.tool.node.ForestNodeMerger;
import com.mtl.system.domain.Menu;
import com.mtl.system.domain.vo.MenuVO;
import com.mtl.system.mapper.MenuMapper;
import com.mtl.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 *
 * @author lsc
 * @since 2019-03-26
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu findById(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveOrUpdate(Menu menu) {
        if(menu.getId()!=null){
            return menuMapper.updateByPrimaryKey(menu);
        }
        menu.setDeleteflag(0);
        menu.setIsDisplay(0);
        if(menu.getPid()==null) {
            menu.setPid(0);
        }
        return menuMapper.insert(menu);
    }

    @Override
    public int delete(Integer id) {
        int children=menuMapper.findByParentId(id);
        if(children>0) {
            return -1;
        }
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<MenuVO> authMenuTree(Integer id) {
        List<String> list=menuMapper.authMenuIds(id);
        StringBuffer ids=new StringBuffer();
        for(String s:list){
            ids.append(s).append(",");
        }
        if(ids.length()>0) {
            ids.deleteCharAt(ids.length()-1);
        }
        List<MenuVO> trees= ForestNodeMerger.merge(menuMapper.authMenu(ids.toString()));
        return trees;
    }

    @Override
    public List<Menu> authMenu(Integer id) {
        List<String> list=menuMapper.authMenuIds(id);
        StringBuffer ids=new StringBuffer();
        for(String s:list){
            ids.append(s).append(",");
        }
        if(ids.length()>0) {
            ids.deleteCharAt(ids.length()-1);
        }
        List<Menu> menus= menuMapper.authMenuList(ids.toString());
        return menus;
    }

    @Override
    /*
	获取角色权限
	* */
    public List<MenuVO> MenuTreeByRole(Integer roleId){
        List<MenuVO> trees= ForestNodeMerger.merge(menuMapper.MenuTreeByRole(roleId));
        return trees;
    }
}
