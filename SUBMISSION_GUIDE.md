# Plugin Hub Submission Guide

This guide walks you through submitting the Gemstone Crab Alert plugin to the RuneLite Plugin Hub.

## Prerequisites Checklist

Before submitting, ensure you have:

- [ ] **Public GitHub Repository** - Your plugin code must be in a public GitHub repo
- [ ] **BSD-2-Clause License** - Add a LICENSE file (see below)
- [ ] **Updated Author Name** - Change "YourUsername" in `runelite-plugin.properties` to your actual name/GitHub username
- [ ] **Updated Description** - The description should say "at or below 5%" not just "below 5%"
- [ ] **Working Plugin** - Test thoroughly before submission
- [ ] **Git Commit Hash** - You'll need the latest commit hash from your GitHub repo

## Step 1: Prepare Your Plugin Repository

### 1.1 Update Plugin Properties

Edit `src/main/resources/runelite-plugin.properties`:

```properties
displayName=Gemstone Crab Alert
author=YourActualName  # CHANGE THIS!
description=Flashes the screen when Gemstone Crab health is at or below 5%
tags=crab,gemstone,alert,flash,pvm,boss
plugins=com.gemstonecrab.GemstoneCrabPlugin
```

### 1.2 Add BSD-2-Clause License

Create a `LICENSE` file in the root directory:

```
BSD 2-Clause License

Copyright (c) 2025, YourName
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
```

**Replace "YourName" with your actual name or GitHub username.**

### 1.3 (Optional) Add Icon

If you want an icon displayed in the Plugin Hub:
- Create `icon.png` in the root directory
- Maximum size: 48×72 pixels
- Must be a PNG file

### 1.4 Create GitHub Repository

1. Go to GitHub and create a new public repository
2. Name it something like `runelite-gemstone-crab-alert` or `gemstone-crab-alert`
3. Initialize with README (optional - you already have one)
4. Push your plugin code:

```bash
cd /Users/andrewlovellecoleman/Downloads/gemstone-crab-plugin
git init
git add .
git commit -m "Initial commit: Gemstone Crab Alert plugin"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
git push -u origin main
```

### 1.5 Get Your Latest Commit Hash

After pushing, get the commit hash:

```bash
git log -1 --format="%H"
```

Or view it on GitHub - it's the 40-character SHA shown on your latest commit.

## Step 2: Fork the Plugin Hub Repository

1. Go to https://github.com/runelite/plugin-hub
2. Click the "Fork" button (top right)
3. This creates a copy in your GitHub account

## Step 3: Create a Branch for Your Plugin

1. In your forked `plugin-hub` repository, click "Create branch"
2. Name it something like `gemstone-crab-alert` (lowercase, no spaces)

## Step 4: Add Your Plugin Manifest

1. Navigate to the `plugins/` directory in your forked repo
2. Create a new file named `gemstone-crab-alert` (no extension)
3. Add this content:

```
repository=https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
commit=YOUR_40_CHARACTER_COMMIT_HASH
```

**Example:**
```
repository=https://github.com/johndoe/runelite-gemstone-crab-alert.git
commit=abc123def4567890123456789012345678901234
```

4. Commit this file to your branch

## Step 5: Submit Pull Request

1. Push your branch to your fork
2. Go to the original `runelite/plugin-hub` repository
3. You should see a banner suggesting to create a PR from your branch
4. Click "Compare & pull request"
5. Fill out the PR description:

**Title:** `Add Gemstone Crab Alert plugin`

**Description:**
```markdown
## Description
Adds a visual alert plugin that flashes the screen when the Gemstone Crab's health drops to a configurable threshold (default: 5%).

## Features
- Configurable health threshold (1-99%)
- Customizable flash color with transparency
- Adjustable flash duration (1-30 seconds)
- Pulsing flash effect with configurable speed
- Triggers exactly when health reaches or drops below threshold

## Repository
https://github.com/YOUR_USERNAME/YOUR_REPO_NAME

## Testing
Plugin has been tested locally and works as expected. It monitors NPC health and provides visual alerts without violating Jagex's third-party client rules.
```

6. Submit the PR

## Step 6: Wait for Review

The RuneLite team will:

1. **Run CI Checks** - Automated build tests
   - If these fail, fix the issues and push updates
   - Check the "Actions" tab in your PR for details

2. **Review Your Code** - They check for:
   - Compliance with Jagex's rules (no unfair advantages)
   - No malicious code
   - Proper licensing
   - Code quality and best practices

3. **Request Changes** (if needed) - Address any feedback

4. **Merge** - Once approved, your plugin will be available in the Plugin Hub!

## Step 7: After Approval

- Your plugin will appear in RuneLite's Plugin Hub
- Users can install it via: Settings → Plugins → Plugin Hub → Search "Gemstone Crab Alert"
- To update your plugin later, submit a new PR updating the `commit=` hash

## Troubleshooting

### CI Build Fails

- Check the Actions tab for error messages
- Common issues:
  - Build errors in your code
  - Missing dependencies
  - Incorrect file structure
  - License file issues

### PR Rejected

- Read the feedback carefully
- Common reasons:
  - Violates Jagex rules
  - Missing or incorrect license
  - Code quality issues
  - Security concerns

### Need Help?

- Check existing plugin PRs for examples: https://github.com/runelite/plugin-hub/pulls
- Review the plugin hub repository: https://github.com/runelite/plugin-hub
- Check RuneLite wiki: https://github.com/runelite/runelite/wiki

## Quick Reference

**Plugin Hub Repo:** https://github.com/runelite/plugin-hub  
**Plugin Hub Website:** https://runelite.net/plugin-hub  
**RuneLite Wiki:** https://github.com/runelite/runelite/wiki

---

**Good luck with your submission!** 🎉
