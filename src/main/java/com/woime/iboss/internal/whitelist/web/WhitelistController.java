package com.woime.iboss.internal.whitelist.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.woime.iboss.api.tenant.TenantHolder;
import com.woime.iboss.core.auth.CurrentUserHolder;
import com.woime.iboss.core.export.Exportor;
import com.woime.iboss.core.mapper.BeanMapper;
import com.woime.iboss.core.page.Page;
import com.woime.iboss.core.query.PropertyFilter;
import com.woime.iboss.core.spring.MessageHelper;
import com.woime.iboss.internal.whitelist.persistence.domain.WhitelistApp;
import com.woime.iboss.internal.whitelist.persistence.manager.WhitelistAppManager;
import com.woime.iboss.internal.whitelist.persistence.manager.WhitelistTypeManager;
import com.woime.iboss.internal.whitelist.service.WhitelistService;

@Controller
@RequestMapping("whitelist")
public class WhitelistController
{
	private WhitelistAppManager whitelistAppManager;
	private WhitelistTypeManager whitelistTypeManager;
	private WhitelistService whitelistService;
	private MessageHelper messageHelper;
	private Exportor exportor;
	private BeanMapper beanMapper = new BeanMapper();
	private CurrentUserHolder currentUserHolder;
	private TenantHolder tenantHolder;

	@RequestMapping("whitelist-list")
	public String list(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model)
	{
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		parameterMap.put("filter_EQS_userId", currentUserHolder.getUsername());
		page = whitelistAppManager.pagedQuery(page, propertyFilters);
		model.addAttribute("page", page);

		return "whitelist/whitelist-list";
	}

	@RequestMapping("whitelist-input")
	public String input(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "type", required = false) String whitelistTypeCode, Model model)
	{
		WhitelistApp whitelistApp = null;

		if (id != null)
		{
			whitelistApp = whitelistAppManager.get(id);
			model.addAttribute("model", whitelistApp);
		}

		if (whitelistApp != null)
		{
			model.addAttribute("whitelistType", whitelistApp.getWhitelistType());
		}
		else if (whitelistTypeCode != null)
		{
			model.addAttribute("whitelistType", whitelistTypeManager.findUniqueBy("code", whitelistTypeCode));
		}
		else
		{
			model.addAttribute("whitelistTypes", whitelistTypeManager.getAll());
		}

		return "whitelist/whitelist-input";
	}

	@RequestMapping("whitelist-save")
	public String save(@ModelAttribute WhitelistApp whitelistApp, @RequestParam("typeId") Long whitelistTypeId, @RequestParam("host") String hostContent, @RequestParam("ip") String ipContent,
			RedirectAttributes redirectAttributes)
	{
		String tenantId = tenantHolder.getTenantId();
		whitelistService.saveWhitelistApp(whitelistApp, whitelistTypeId, hostContent, ipContent, currentUserHolder.getUsername(), tenantId);
		messageHelper.addFlashMessage(redirectAttributes, "core.success.save", "保存成功");

		return "redirect:/whitelist/whitelist-list.do";
	}

	// ~ ======================================================================
	@Resource
	public void setWhitelistAppManager(WhitelistAppManager whitelistAppManager)
	{
		this.whitelistAppManager = whitelistAppManager;
	}

	@Resource
	public void setWhitelistTypeManager(WhitelistTypeManager whitelistTypeManager)
	{
		this.whitelistTypeManager = whitelistTypeManager;
	}

	@Resource
	public void setWhitelistService(WhitelistService whitelistService)
	{
		this.whitelistService = whitelistService;
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
	public void setCurrentUserHolder(CurrentUserHolder currentUserHolder)
	{
		this.currentUserHolder = currentUserHolder;
	}

	@Resource
	public void setTenantHolder(TenantHolder tenantHolder)
	{
		this.tenantHolder = tenantHolder;
	}
}
