package com.woime.iboss.internal.whitelist.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.woime.iboss.api.tenant.TenantHolder;
import com.woime.iboss.core.export.Exportor;
import com.woime.iboss.core.export.TableModel;
import com.woime.iboss.core.mapper.BeanMapper;
import com.woime.iboss.core.page.Page;
import com.woime.iboss.core.query.PropertyFilter;
import com.woime.iboss.core.spring.MessageHelper;
import com.woime.iboss.internal.whitelist.persistence.domain.WhitelistApp;
import com.woime.iboss.internal.whitelist.persistence.manager.WhitelistAppManager;

@Controller
@RequestMapping("whitelist")
public class WhitelistAppController
{
	private WhitelistAppManager whitelistAppManager;
	private MessageHelper messageHelper;
	private Exportor exportor;
	private BeanMapper beanMapper = new BeanMapper();
	private TenantHolder tenantHolder;

	@RequestMapping("whitelist-app-list")
	public String list(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model)
	{
		String tenantId = tenantHolder.getTenantId();
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		propertyFilters.add(new PropertyFilter("EQS_tenantId", tenantId));
		page = whitelistAppManager.pagedQuery(page, propertyFilters);
		model.addAttribute("page", page);

		return "whitelist/whitelist-app-list";
	}

	@RequestMapping("whitelist-app-input")
	public String input(@RequestParam(value = "id", required = false) Long id, Model model)
	{
		if (id != null)
		{
			WhitelistApp whitelistApp = whitelistAppManager.get(id);
			model.addAttribute("model", whitelistApp);
		}

		return "whitelist/whitelist-app-input";
	}

	@RequestMapping("whitelist-app-save")
	public String save(@ModelAttribute WhitelistApp whitelistApp, RedirectAttributes redirectAttributes)
	{
		String tenantId = tenantHolder.getTenantId();
		Long id = whitelistApp.getId();
		WhitelistApp dest = null;

		if (id != null)
		{
			whitelistApp = whitelistAppManager.get(id);
			beanMapper.copy(whitelistApp, dest);
		}
		else
		{
			dest = whitelistApp;
			dest.setTenantId(tenantId);
		}

		whitelistAppManager.save(dest);
		messageHelper.addFlashMessage(redirectAttributes, "core.success.save", "保存成功");

		return "redirect:/whitelist/whitelist-app-list.do";
	}

	@RequestMapping("whitelist-app-remove")
	public String remove(@RequestParam("selectedItem") List<Long> selectedItem, RedirectAttributes redirectAttributes)
	{
		List<WhitelistApp> whitelistApps = whitelistAppManager.findByIds(selectedItem);
		whitelistAppManager.removeAll(whitelistApps);
		messageHelper.addFlashMessage(redirectAttributes, "core.success.delete", "删除成功");

		return "redirect:/whitelist/whitelist-app-list.do";
	}

	@RequestMapping("whitelist-app-export")
	public void export(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String tenantId = tenantHolder.getTenantId();
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		propertyFilters.add(new PropertyFilter("EQS_tenantId", tenantId));
		page = whitelistAppManager.pagedQuery(page, propertyFilters);

		List<WhitelistApp> whitelistApps = (List<WhitelistApp>) page.getResult();

		TableModel tableModel = new TableModel();
		tableModel.setName("whitelistApp");
		tableModel.addHeaders("id", "name");
		tableModel.setData(whitelistApps);
		exportor.export(request, response, tableModel);
	}

	// ~ ======================================================================
	@Resource
	public void setWhitelistAppManager(WhitelistAppManager whitelistAppManager)
	{
		this.whitelistAppManager = whitelistAppManager;
	}

	@Resource
	public void setMessageHelper(MessageHelper messageHelper)
	{
		this.messageHelper = messageHelper;
	}

	@Resource
	public void setExportor(Exportor exportor)
	{
		this.exportor = exportor;
	}

	@Resource
	public void setTenantHolder(TenantHolder tenantHolder)
	{
		this.tenantHolder = tenantHolder;
	}
}
