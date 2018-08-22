package com.selman.billrec.controller;

import com.selman.billrec.exception.ResourceNotFoundException;
import com.selman.billrec.model.PreferenceSettings;
import com.selman.billrec.repository.PreferenceSettingsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PareferenceSettingsController {

    @Autowired
    PreferenceSettingsRepository preferenceSettingsRepository;

    @GetMapping("/preferenceSettings")
    public List<PreferenceSettings> getAllPreferenceSettings() {
        return preferenceSettingsRepository.findAll();
    }
    
    @PostMapping("/preferenceSettings")
    public PreferenceSettings createPreferenceSettings(@Valid @RequestBody PreferenceSettings preferenceSettings) {
        return preferenceSettingsRepository.save(preferenceSettings);
    }

    @GetMapping("/preferenceSettings/{id}")
    public PreferenceSettings getPreferenceSettingsById(@PathVariable(value = "id") Long preferenceSettingsPk) {
        return preferenceSettingsRepository.findById(preferenceSettingsPk)
                .orElseThrow(() -> new ResourceNotFoundException("PreferenceSettings", "preferenceSettingsPk", preferenceSettingsPk));
    }

    @PutMapping("/preferenceSettings/{id}")
    public PreferenceSettings updatePreferenceSettings(@PathVariable(value = "id") Long preferenceSettingsPk,
                                            @Valid @RequestBody PreferenceSettings preferenceSettingsDetails) {

        PreferenceSettings preferenceSettings = preferenceSettingsRepository.findById(preferenceSettingsPk)
                .orElseThrow(() -> new ResourceNotFoundException("PreferenceSettings", "preferenceSettingsPk", preferenceSettingsPk));

        preferenceSettings.setModUser(preferenceSettingsDetails.getModUser());
        preferenceSettings.setGroupFk(preferenceSettingsDetails.getGroupFk());
        preferenceSettings.setPreferenceType(preferenceSettingsDetails.getPreferenceType());
        preferenceSettings.setEnabled(preferenceSettingsDetails.getEnabled());

        PreferenceSettings updatedPreferenceSettings = preferenceSettingsRepository.save(preferenceSettings);
        return updatedPreferenceSettings;
    }

    @DeleteMapping("/preferenceSettings/{id}")
    public ResponseEntity<?> deletePreferenceSettings(@PathVariable(value = "id") Long preferenceSettingsPk) {
        PreferenceSettings preferenceSettings = preferenceSettingsRepository.findById(preferenceSettingsPk)
                .orElseThrow(() -> new ResourceNotFoundException("PreferenceSettings", "preferenceSettingsPk", preferenceSettingsPk));
        

        preferenceSettingsRepository.delete(preferenceSettings);

        return ResponseEntity.ok().build();
    }

}